package com.ubrain.alertdialogdemo

import android.app.AlertDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.Button
import android.widget.Toast

/*
1)Display button and click on that open alert dialog box.
i)using ok , cancel button
ii)using yes, no , cancel button
iii)with only one button ok button
->Please also toast button text after clicking of alert button (EX: you click alert ok button , you click Cancel button)
*/

class AlertDialogActivity : AppCompatActivity() {
    lateinit var alertDialog:AlertDialog.Builder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)


        var btnTwoAlertDialog:Button=findViewById(R.id.btn_two_alert_dialog) as Button
        var btnThreeAlertDialog:Button=findViewById(R.id.btn_three_alert_dialog) as Button
        var btnOneAlertDialog:Button=findViewById(R.id.btn_one_alert_dialog) as Button


        btnTwoAlertDialog.setOnClickListener {
       alertDialog=AlertDialog.Builder(this@AlertDialogActivity)
            alertDialog.setMessage("ALlert using ok and cancel Button...")
            alertDialog.setTitle("Alert Dialog")

            alertDialog.setIcon(ContextCompat.getDrawable(this@AlertDialogActivity,R.drawable.alert))

            //alertDialog.setPositiveButton("yes", { dialog, which ->  })
           alertDialog.setPositiveButton("Ok", object:DialogInterface.OnClickListener{

                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@AlertDialogActivity,"You clicked ok button",Toast.LENGTH_LONG).show()
                }
            })

            alertDialog.setNegativeButton("cancel", object:DialogInterface.OnClickListener{

                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(this@AlertDialogActivity,"You clicked cancel button",Toast.LENGTH_LONG).show()
                }
            }
            )
            alertDialog.show()

        }

        btnThreeAlertDialog.setOnClickListener {
            alertDialog=AlertDialog.Builder(this@AlertDialogActivity)
            alertDialog.setTitle("Alert Dialog")
            alertDialog.setTitle("using yes,no and cancel button...")
            alertDialog.setIcon(R.drawable.alert_dialog)
            alertDialog.setPositiveButton("YES", object:DialogInterface.OnClickListener{

                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(applicationContext,"you clicked YES button!",Toast.LENGTH_SHORT).show()
                }
            })
            alertDialog.setNegativeButton("NO", object:DialogInterface.OnClickListener{

                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(applicationContext,"you clicked NO button!",Toast.LENGTH_SHORT).show()
                }
            })
            alertDialog.setNeutralButton("Cancel", object:DialogInterface.OnClickListener{

                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(applicationContext,"you clicked Cancel button!",Toast.LENGTH_SHORT).show()
                }
            })
            alertDialog.show()
        }

        btnOneAlertDialog.setOnClickListener {
            alertDialog=AlertDialog.Builder(this@AlertDialogActivity)
            alertDialog.setTitle("Alert Dialog")
            alertDialog.setTitle("using OK button...")
            alertDialog.setIcon(R.drawable.alert_dialog)
            alertDialog.setPositiveButton("Ok", object:DialogInterface.OnClickListener{

                override fun onClick(dialog: DialogInterface?, which: Int) {
                    Toast.makeText(applicationContext,"you clicked OK button!",Toast.LENGTH_SHORT).show()
                }
            })
          alertDialog.show()
        }
    }
}
