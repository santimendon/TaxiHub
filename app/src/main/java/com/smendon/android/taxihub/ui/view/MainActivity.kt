package com.smendon.android.taxihub.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.smendon.android.taxihub.R

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val currentLocation = LatLng(19.230960282757305, 72.85666672993376)
        val cabLocation = LatLng(19.22930802284693, 72.85603584114645)

        val markerCurrentLocation = MarkerOptions()
            .position(currentLocation)
            .title("You are here")
            .draggable(true)
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_pin))

        val markerCabLocation = MarkerOptions()
            .position(cabLocation)
            .draggable(true)
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cab))

        mMap.addMarker(markerCurrentLocation)
        mMap.addMarker(markerCabLocation)

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 10F));
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
        mMap.animateCamera(CameraUpdateFactory.zoomTo(20F), 1000, null);
    }
}