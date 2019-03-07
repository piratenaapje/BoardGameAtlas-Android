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
import android.view.Menu
import com.poofinc.boardgameatlas.ui.fragment.GamesFragment

class MainActivity : AppCompatActivity() {
    var mFragment: MainFragment? = null

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

        openPage(HomeFragment(), "Home", null)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawer_layout.openDrawer(GravityCompat.START)
                true
            }
            R.id.sort_option_1 -> {
                mFragment?.selectSortOption(0)
                true
            }
            R.id.sort_option_2 -> {
                mFragment?.selectSortOption(1)
                true
            }
            R.id.sort_option_3 -> {
                mFragment?.selectSortOption(2)
                true
            }
            R.id.sort_option_4 -> {
                mFragment?.selectSortOption(3)
                true
            }
            R.id.sort_option_5 -> {
                mFragment?.selectSortOption(4)
                true
            }
            R.id.sort_option_6 -> {
                mFragment?.selectSortOption(5)
                true
            }
            R.id.sort_option_7 -> {
                mFragment?.selectSortOption(6)
                true
            }
            R.id.sort_option_8 -> {
                mFragment?.selectSortOption(7)
                true
            }
            R.id.sort_option_9 -> {
                mFragment?.selectSortOption(8)
                true
            }
            R.id.sort_reverse -> {
                mFragment?.reverseSorting()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun openPage(fragment: MainFragment?, title: String?, subtitleFinal: String?) {
        mFragment = fragment
        var subtitle = subtitleFinal
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_holder, fragment)
                    .commit();
            if (fragment.showSortMenuItem && subtitle == null) {
                if (fragment.sortOptions.size > 0) {
                    subtitle = fragment.sortOptions[0].displayName
                }
            }
        }
        invalidateOptionsMenu()
        setTitle(title, subtitle)
    }

    fun setTitle(title: String?, subtitle: String?) {
        supportActionBar?.title = title
        supportActionBar?.subtitle = subtitle
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        var sortItem = menu.findItem(R.id.sort)
        var reverseItem = menu.findItem(R.id.sort_reverse)
        if (mFragment?.showSortMenuItem == false) {
            sortItem.isVisible = false
            reverseItem.isVisible = false
        } else if (mFragment != null){
            for (i in 0 until sortItem.subMenu.size()) {
                if (i < mFragment?.sortOptions!!.size) {
                    sortItem.subMenu.getItem(i).title = mFragment!!.sortOptions[i].displayName
                } else {
                    sortItem.subMenu.getItem(i).isVisible = false
                }
            }
        }
        return true
    }



}
