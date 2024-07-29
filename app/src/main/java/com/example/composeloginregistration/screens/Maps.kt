package com.example.composeloginregistration.screens

import android.annotation.SuppressLint
import android.location.Location
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.composeloginregistration.screens.auth.viewmodel.AuthenticationViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.LocationSource
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.shareIn
import kotlin.random.Random

var singapore =
    mutableStateOf(LatLng(1.35, 103.87))

@Composable
fun GoogleMaps(authenticationViewModel: AuthenticationViewModel) {
    var isMapLoaded by remember { mutableStateOf(false) }


    var counter = 0
     val locationSource = MyLocationSource()

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore.value, 10f)
    }

    val mapProperties by remember {
        mutableStateOf(MapProperties(isMyLocationEnabled = true))
    }
     val locationFlow = callbackFlow {
        while (true) {
            ++counter

            val location = newLocation()

            Log.d("TAG", "Location $counter: $location")
            delay(5000)
            trySend(location)
            singapore.value=LatLng(location.latitude,location.longitude)


        }
    }
    val locationState = locationFlow.collectAsState(initial = newLocation())
    LaunchedEffect(locationState.value) {
        Log.d("TAG", "Updating blue dot on map...")
        locationSource.onLocationChanged(locationState.value)

        Log.d("TAG", "Updating camera position...")
        val cameraPosition = CameraPosition.fromLatLngZoom(LatLng(locationState.value.latitude, locationState.value.longitude), 16f)
        cameraPositionState.animate(CameraUpdateFactory.newCameraPosition(cameraPosition), 1_000)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState, onMapLoaded = {
            isMapLoaded=true
        }, properties = mapProperties,
        onMyLocationButtonClick = {  Log.d("TAG","Overriding the onMyLocationButtonClick with this Log"); true },
        locationSource = locationSource,

    ) {
        Marker(
            state = MarkerState(position = singapore.value),
            title = "Singapore",
            snippet = "Marker in Singapore"
        )
    }
}
 fun newLocation(): Location {
    val location = Location("MyLocationProvider")
    location.apply {
        latitude = singapore.value.latitude + Random.nextFloat()
        longitude = singapore.value.longitude + Random.nextFloat()
    }
    return location
}
class MyLocationSource : LocationSource {

    private var listener: LocationSource.OnLocationChangedListener? = null

    override fun activate(listener: LocationSource.OnLocationChangedListener) {
        this.listener = listener
    }

    override fun deactivate() {
        listener = null
    }

    fun onLocationChanged(location: Location) {
        listener?.onLocationChanged(location)
    }
}