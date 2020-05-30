/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 */
package com.example.justjava

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


/**
 * This app displays an order form to order coffee.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * This method is called when the order button is clicked.
         */
        button.setOnClickListener {
            displayQuantity(numberOfCoffees)
            val message =
                """
                    ${getString(R.string.name)}: ${name_edit_text.text}
                    ${getString(R.string.quantity)}: $numberOfCoffees
                    ${getString(R.string.whipped_cream)}: ${whipped_cream_checkbox.isChecked}
                    ${getString(R.string.chocolate)}: ${chocolate_checkbox.isChecked}
                    ${getString(R.string.total)}: ${calculatePrice()} $
                    ${getString(R.string.thank_you)}
                """.trimIndent()

            displayMessage(message)

            val addresses = listOf(
                "fake@address.com", "some@add.com").toTypedArray()
            val subject = "${name_edit_text.text}'s order"

            sendEmail(addresses, subject, message)
        }

        plus_button.setOnClickListener {
            if (numberOfCoffees < 100) {
                numberOfCoffees += 1
                displayQuantity(numberOfCoffees)
            }
        }

        minus_button.setOnClickListener {
            if (numberOfCoffees > 0) {
                numberOfCoffees -= 1
                displayQuantity(numberOfCoffees)
            }
        }
    }

    private var numberOfCoffees = 0

    /**
     * This method displays the given quantity value on the screen.
     */
    private fun displayQuantity(number: Int) {
        quantity_text_view.text = number.toString()
    }

    private fun displayMessage(message: String) {
        price_text_view.text = message
    }

    private fun calculatePrice(): Int {
        var pricePerCup = 5
        val priceForChocolate = 2
        val priceForWhippedCream = 1

        if (whipped_cream_checkbox.isChecked) pricePerCup += priceForWhippedCream
        if (chocolate_checkbox.isChecked) pricePerCup += priceForChocolate
        return numberOfCoffees * (pricePerCup)
    }

    private fun sendEmail(addresses: Array<String>, subject: String, text: String) {
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, text)
        }

        try {
            //start email intent
            startActivity(Intent.createChooser(emailIntent, "Choose Email Client..."))
        } catch (e: Exception) {
            //if any thing goes wrong for example no email client application or any exception
            //get and show exception message
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }
}