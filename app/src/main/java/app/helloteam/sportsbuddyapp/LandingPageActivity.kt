package app.helloteam.sportsbuddyapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.parse.ParseUser
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class LandingPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        val date = Date()
        Toast.makeText(this, "$date", Toast.LENGTH_SHORT).show()

        ParseCode.EventDeletion(date)

        val showuser = findViewById<TextView>(R.id.ShowUsername)

        showuser.text = ParseUser.getCurrentUser().username

       // val logoutBtn = findViewById<Button>(R.id.LogoutBtn)//gets logout button id
      //  val profileBtn = findViewById<Button>(R.id.ToProfileBtn) // gets profile button id
      //  val mapBtn = findViewById<Button>(R.id.mapBtn)//switch to map layout
        val createEventBtn = findViewById<Button>(R.id.CreateEventBtn)//create event layout

   /*     logoutBtn.setOnClickListener {//logs user out when they click the logout button
            UserHandling.Logout()
            afterLogout()
        }

        profileBtn.setOnClickListener {
            val intent = Intent(this, ProfilePage::class.java)
            startActivity(intent)
        }

        //switches view to map
        mapBtn.setOnClickListener {
            val intent = Intent(this, map::class.java)
            startActivity(intent)
        }
        */
        createEventBtn.setOnClickListener {
            val intent = Intent(this, CreateEvent::class.java)
            startActivity(intent)
        }

    }

    fun afterLogout() {//method to go back to login screen after logout
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
    R.id.action_profile -> {
        Toast.makeText(this, "You selected Profile", Toast.LENGTH_LONG).show()
        true
    }
        R.id.action_logout  -> {
            UserHandling.Logout()
            afterLogout()
            true
        }
        R.id.action_map -> {
            val intent = Intent(this, map::class.java)
            startActivity(intent)
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }


}