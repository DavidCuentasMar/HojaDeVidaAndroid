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
class HomeFragment : Fragment(), View.OnClickListener {
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

        personObj1 = UserPersonalModel("Juanita Perez", 30, "Dormir", 2, R.mipmap.honoree_avatar)
        personObj2 = UserPersonalModel("David Cuentas", 23, "Ver Series", 1, R.mipmap.honoree_avatar)
        personObj3 = UserPersonalModel("Wilson Tovar", 21, "Leer poesía", 2, R.mipmap.honoree_avatar)

        view.findViewById<Button>(R.id.p1Btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.p2Btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.p3Btn).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.p1Btn -> {
                val bundle = bundleOf("data" to personObj1, "nombre" to personObj1.name)
                navController!!.navigate(R.id.action_homeFragment_to_mainFragment, bundle)
            }
            R.id.p2Btn -> {
                val bundle = bundleOf("data" to personObj2, "nombre" to personObj2.name)
                navController!!.navigate(R.id.action_homeFragment_to_mainFragment, bundle)
            }
            R.id.p3Btn -> {
                val bundle = bundleOf("data" to personObj3, "nombre" to personObj3.name)
                navController!!.navigate(R.id.action_homeFragment_to_mainFragment, bundle)
            }

        }
    }
}
