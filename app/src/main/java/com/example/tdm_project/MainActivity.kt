package com.example.tdm_project
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatDelegate
import android.util.Log
import android.view.MenuItem

val TAG = "TAG-MainActivity"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpBottomNavigationBar()

        if (AppCompatDelegate.getDefaultNightMode()== AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.DarkAppTheme)
        }else{
            setTheme(R.style.AppTheme)
        }


    }
    private fun SetFagment(fragment: Fragment?):Boolean{
        if(fragment != null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()
            return true
        }
        return false
    }

    // Sending the token to the fragement
    private fun setUpBottomNavigationBar() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener{
                    val fragment: Fragment
                    when (it.itemId) {
                        R.id.nav_home -> fragment = HomeFragment()
                        R.id.nav_profile -> fragment = ProfileFragment()
                        R.id.nav_saved-> fragment = SavedFragment()
                        else -> fragment = HomeFragment()
                    }

                    return@setOnNavigationItemSelectedListener SetFagment(fragment)
                }

        bottomNavigationView.selectedItemId = R.id.nav_home  /// consult .. just for the test
    }

    private fun attachArgs(tag: String, data: String): Bundle {
        var bundle = Bundle()
        bundle.putString(tag, data)
        return bundle
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }




}
