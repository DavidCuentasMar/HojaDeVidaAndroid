package com.uninorte.hojadevida


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.uninorte.hojadevida.model.UserPersonalModel

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    lateinit var user: UserPersonalModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        user = arguments!!.getParcelable("data")!!


        view.findViewById<TextView>(R.id.textView).text = user.name
        view.findViewById<TextView>(R.id.textView2).text = user.hobby
        view.findViewById<TextView>(R.id.textView3).text = "${user.edad} años"

        view.findViewById<Button>(R.id.button_personal).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       when(v!!.id){

           R.id.button_personal -> {
               val bundle = bundleOf("data" to user, "nombre" to user.name)
               navController!!.navigate(R.id.action_mainFragment_to_personalFragment,bundle)
           }

       }
    }
}
