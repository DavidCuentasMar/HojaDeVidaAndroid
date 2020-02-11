package com.uninorte.hojadevida


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.uninorte.hojadevida.model.UserPersonalModel

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {
    lateinit var navController: NavController
    lateinit var personObj1: UserPersonalModel
    lateinit var personObj2: UserPersonalModel
    lateinit var personObj3: UserPersonalModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        personObj1 = UserPersonalModel("Juanita Perez",20,"Ver TV", 2)
        personObj1 = UserPersonalModel("David Cuentas",20,"Ver TV", 2)
        personObj1 = UserPersonalModel("Juanita Perez",20,"Ver TV", 2)
        view.findViewById<Button>(R.id.button_personal).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){

            R.id.button_personal -> {
                val bundle = bundleOf("data" to userPersonalModel, "nombre" to userPersonalModel.name)
                navController!!.navigate(R.id.action_mainFragment_to_personalFragment,bundle)
            }

        }
    }
}
