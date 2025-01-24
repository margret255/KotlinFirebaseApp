package com.example.mykotlinapp.pages

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mykotlinapp.R

class Donations : AppCompatActivity() {

    // Declare variables for the views
    private lateinit var nameEditText: EditText
    private lateinit var foodNameEditText: EditText
    private lateinit var preferredTimeEditText: EditText
    private lateinit var dateEditText: EditText
    private lateinit var quantityEditText: EditText
    private lateinit var foodImageView: ImageView
    private lateinit var submitButton: Button

    // Constant for image pick request code
    private val PICK_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.donations)

        // Initialize the views
        nameEditText = findViewById(R.id.name)
        foodNameEditText = findViewById(R.id.food_name)
        preferredTimeEditText = findViewById(R.id.preferred_time)
        dateEditText = findViewById(R.id.date)
        quantityEditText = findViewById(R.id.quantity)
        foodImageView = findViewById(R.id.food_image)
        submitButton = findViewById(R.id.submit_button)

        // Set up an OnClickListener for the submit button
        submitButton.setOnClickListener {

            // Gather input data
            val name = nameEditText.text.toString().trim()
            val foodName = foodNameEditText.text.toString().trim()
            val preferredTime = preferredTimeEditText.text.toString().trim()
            val date = dateEditText.text.toString().trim()
            val quantity = quantityEditText.text.toString().trim()

            // Input validation
            if (name.isEmpty() || foodName.isEmpty() || preferredTime.isEmpty() || date.isEmpty() || quantity.isEmpty()) {
                Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Log the gathered data (This is where you can send data to your backend or save it)
            println("Name: $name")
            println("Food Type: $foodName")
            println("Preferred Time: $preferredTime")
            println("Date: $date")
            println("Quantity: $quantity")

            // Handle image upload (if any)
            // Assuming foodImageView contains the selected image
            // This is where you would save or process the image.

            Toast.makeText(this, "Donation details submitted successfully!", Toast.LENGTH_LONG).show()

            // Clear the input fields
            nameEditText.text.clear()
            foodNameEditText.text.clear()
            preferredTimeEditText.text.clear()
            dateEditText.text.clear()
            quantityEditText.text.clear()
            foodImageView.setImageDrawable(null) // Reset image view
        }

        // Set up image upload when image view is clicked
        foodImageView.setOnClickListener {
            // Launch an intent to pick an image from the gallery
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }
    }

    // Handle result from image picker
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri = data.data
            foodImageView.setImageURI(selectedImageUri) // Set the selected image in ImageView
        }
    }
}
