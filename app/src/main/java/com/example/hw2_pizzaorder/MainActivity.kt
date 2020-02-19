package com.example.hw2_pizzaorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.Switch
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var base = 0.00;
    var totalPrice = 0.00;
    var extra = 0;
    var deliverPrice = 0.00;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pizzaList = listOf("Pepperoni", "Margherita", "Hawaiian", "BBQ Chicken")

        val myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pizzaList)

        pizza_list.adapter = myAdapter

        pizza_list.setOnItemClickListener { list, item, position, id ->
            val selectedItem = list.getItemAtPosition(position).toString()
            Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show()

            val imageId = when (position) {
                0 -> R.drawable.pepperoni
                1 -> R.drawable.margheritta
                2 -> R.drawable.hawaiian
                3 -> R.drawable.bbq_chicken
                else -> R.drawable.pepperoni
            }

            image_pizza.setImageResource(imageId)
        }
    }

    fun radioClick(view:View) {
        if (view == med) {
            base = 9.99
            calcTotal()
        }
        else if (view == lrg) {
            base = 13.99
            calcTotal()
        }
        else if (view == xlrg) {
            base = 15.99
            calcTotal()
        }
    }

    fun checkBoxes(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.cheese -> {
                    if (checked) {
                        extra++
                    } else {
                        extra--
                    }
                }
                R.id.mushroom -> {
                    if (checked) {
                        extra++
                    } else {
                        extra--
                    }
                }
                R.id.onion -> {
                    if (checked) {
                        extra++
                    } else {
                        extra--
                    }
                }
                R.id.spinich -> {
                    if (checked) {
                        extra++
                    } else {
                        extra--
                    }
                }
                R.id.broccoli -> {
                    if (checked) {
                        extra++
                    } else {
                        extra--
                    }
                }
                R.id.olives -> {
                    if (checked) {
                        extra++
                    } else {
                        extra--
                    }
                }
                R.id.tomatoes -> {
                    if (checked) {
                        extra++
                    } else {
                        extra--
                    }
                }
            }
        }
        calcTotal()
    }

    fun deliver(view: View) {
        val sw = findViewById<Switch>(R.id.deliver)
        if (sw.isChecked) {
            deliverPrice = 2.00
            deliver.text = "Yes $2.00"
            calcTotal()
        }
        else {
            deliverPrice = 0.00
            deliver.text = "No $0.00"
            calcTotal()
        }
    }

    fun calcTotal() {
        var extraToppings = 1.69 * extra
        totalPrice = base + deliverPrice + extraToppings

        price.text = "%.2f".format(totalPrice)
    }
}
