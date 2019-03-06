package com.poofinc.boardgameatlas.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.android.volley.Response
import com.poofinc.boardgameatlas.R
import com.poofinc.boardgameatlas.core.game.SearchRequest
import com.poofinc.boardgameatlas.data.search.Order
import com.poofinc.boardgameatlas.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.NavigationView
import com.poofinc.boardgameatlas.ui.fragment.GamesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        val navigationView: NavigationView = findViewById(R.id.nav_view)

        navigationView.setNavigationItemSelectedListener {
            var openPage = !it.isChecked
            it.isChecked = true
            drawer_layout.closeDrawers()

            if (openPage) {
                when (it.itemId) {
                    R.id.home -> openPage(HomeFragment(), "Home", null)
                    R.id.games -> openPage(GamesFragment(), "Games", null)
                }
            }

            true
        }

        supportFragmentManager.beginTransaction()
                .add(R.id.fragment_holder, HomeFragment())
                .commit();

        setTitle("Home", null)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawer_layout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun openPage(fragment: Fragment?, title: String?, subtitle: String?) {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_holder, fragment)
                    .commit();
        }
        setTitle(title, subtitle)
    }

    fun setTitle(title: String?, subtitle: String?) {
        supportActionBar?.title = title
        supportActionBar?.subtitle = subtitle
    }


}
