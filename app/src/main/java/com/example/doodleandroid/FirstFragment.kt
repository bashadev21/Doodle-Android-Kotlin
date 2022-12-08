package com.example.doodleandroid

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {

    private lateinit var goAcBtn:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


val view=inflater.inflate(R.layout.fragment_first, container, false)
        goAcBtn=view.findViewById(R.id.frag1btn)

        val secondFragment=SecondFragment()
        val firstFragment=FirstFragment()

        goAcBtn.setOnClickListener {
            println("Hye")
            val bundle=Bundle()
            bundle.putString("name","yessss")
            secondFragment.arguments=bundle

           activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_fragment,secondFragment)?.commit()
//            childFragmentManager.beginTransaction().replace(R.id.firstFrag,secondFragment).commit()
//           println( childFragmentManager.beginTransaction().isEmpty)
//            if(childFragmentManager.isStateSaved){
//                println("Hrllsls")
//                childFragmentManager.beginTransaction().add(R.id.secondfrag,firstFragment).commit()
//                childFragmentManager.beginTransaction().
//                            replace(R.id.secondfrag,firstFragment).commit()
//
//            }else{
//                childFragmentManager.beginTransaction().
//                replace(R.id.firstFrag,secondFragment).commit()
//
//            }

//            val intentRegister = Intent(
//                requireActivity().applicationContext,
//                MainActivity::class.java
//            )
////            startActivity(intentRegister)
//          //  val passData=Intent(this,MainActivity::class.java)
//
//            startActivity(intentRegister)
        }
        return view
    }

    override fun onStart() {
        println("onstart")
        super.onStart()
    }

    override fun onResume() {
        println("onresume")

        super.onResume()
    }

    override fun onPause() {
        println("onpause")

        super.onPause()
    }

    override fun onStop() {
        println("onstop")

        super.onStop()
    }

    override fun onDestroy() {
        println("ondestroy")

        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("onviewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        println("view state stored")
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onDestroyView() {
        println("DestroyView")
        super.onDestroyView()
    }
}