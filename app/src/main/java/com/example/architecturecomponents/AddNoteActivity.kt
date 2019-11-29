package com.example.architecturecomponents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_note.*

class AddNoteActivity : AppCompatActivity() {

    companion object{
         val EXTRA_TITLE = "com.example.architecturecomponents.EXTRA_TITLE"
         val EXTRA_DESCRIPTION = "com.example.architecturecomponents.EXTRA_DESCRIPTION"
         val EXTRA_PR = "com.example.architecturecomponents.EXTRA_PR"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close_black_24dp)
        setTitle("Add Note")

        number_picker_priority.minValue = 0
        number_picker_priority.maxValue = 10

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater = menuInflater
        menuInflater.inflate(R.menu.add_note_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.save_note -> {
            saveNote()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    fun saveNote() {
        var title = edit_text_title.text.toString()
        var description = edit_text_description.text.toString()
        var priority = number_picker_priority.value

        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(
                this@AddNoteActivity,
                "Please insert title and description",
                Toast.LENGTH_SHORT
            ).show()
            return
        }

        var data = Intent()
        data.putExtra(EXTRA_TITLE,title)
        data.putExtra(EXTRA_DESCRIPTION ,description)
        data.putExtra(EXTRA_PR,priority)
        setResult(Activity.RESULT_OK,data)
        finish()
    }
}
