package com.example.doodleandroid

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import me.relex.circleindicator.CircleIndicator

class MainActivity : AppCompatActivity(),RecyleronTap  {
    var initrate:Int=0


    private lateinit var recylerView:RecyclerView
    private lateinit var etEmail:EditText
    private lateinit var objData:TextView
    private lateinit var etPassword:EditText
    private lateinit var btnLogin:Button
    private lateinit var goToBtn:Button
    private lateinit var goAcBtn:Button
    private lateinit var tabLayout:TabLayout
    private lateinit var viewPager: ViewPager

    private lateinit var adaptor: ProductAdaptor

    private lateinit var list:ArrayList<User>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //FragmentLayout-fragment_view
        //ViewPagerLayout-view_pager
        //TabLayout-tab_layout
        setContentView(R.layout.fragment_view)
//        goToBtn=findViewById(R.id.gobtn)
////        goAcBtn=findViewById(R.id.frag1btn)
       val firstFragment=FirstFragment()
//
//        goToBtn.setOnClickListener {
//            goToBtn.visibility = View.GONE
//                supportFragmentManager.beginTransaction().add(R.id.activity_first,firstFragment).commit()
//
//        }
//        goAcBtn.setOnClickListener {
//            goToBtn.visibility = View.VISIBLE
//            supportFragmentManager.beginTransaction().replace(R.id.activity_first,firstFragment).commit()
//
//        }

//        etEmail=findViewById(R.id.etEmail)
//        etPassword=findViewById(R.id.etPassword)
//        btnLogin=findViewById(R.id.btnLogin)
//        objData=findViewById(R.id.txtDataObj)
//
//        btnLogin.setOnClickListener{
//            println(etEmail.text.toString())
//            println(etPassword.text.toString())
//            val passData=Intent(this,Activity_Get_Data::class.java)
//            passData.putExtras(bundleOf("id" to 5,"username" to "heloo","demoList" to arrayListOf("Hey","Helo")))
//            passData.putExtra("email",etEmail.text.toString())
//            passData.putExtra("password",etPassword.text.toString())
//            startActivityForResult(passData,100)
//        }

////      var  user = intent.getSerializableExtra("dataObj") as? UserData

//        var fff=intent.extras?.getSerializable("dataObj") as? UserData
//        objData.setText(user?.email.toString()+"----"+user?.password.toString())
//        tabLayout=findViewById(R.id.tab_layout)
//        viewPager=findViewById(R.id.tabs)
//        tabLayout.addTab(tabLayout.newTab().setText("First Tab"))
//        tabLayout.addTab(tabLayout.newTab().setText("Second Tab"))
//        tabLayout.tabGravity=TabLayout.GRAVITY_FILL
//        val adaptor=TabAdaptor(this,supportFragmentManager,tabLayout.tabCount)
//        viewPager.adapter=adaptor
//        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
//        tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                viewPager.currentItem=tab!!.position
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//            }
//
//        })
//        viewPager.addOnPageChangeListener(TabLayout.)
//        val list1= listOf("Heloo","Demo","Test")
//        val viewPagerAdaptor=PageViewAdaptor(list1)
//        var vp=  findViewById<ViewPager2>(R.id.vpslider)
//        vp.adapter=viewPagerAdaptor
      //  findViewById<CircleIndicator>(R.id.circleIndicator).setViewPager(vp)
      //  setUI()

   //     val firstFragment=FirstFragment()
        val secondFragment=SecondFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_fragment,firstFragment)
//            addToBackStack(null)
            commit()
        }

findViewById<Button>(R.id.btn_1).
       setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.main_fragment,firstFragment)
//                addToBackStack(null)
                commit()
            }
        }

        findViewById<Button>(R.id.btn_2).
        setOnClickListener{

            supportFragmentManager.beginTransaction().apply {
////                add(R.id.main_fragment,firstFragment)
//
                replace(R.id.main_fragment,secondFragment)
//                addToBackStack(null)

                commit()
            }
        }

    }
    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==100){
            if(resultCode== RESULT_OK){
                var  user = data?.getSerializableExtra("dataObj") as? UserData
                objData.setText(user?.email.toString()+"----"+user?.password.toString())
            }else{
                objData.setText("No data")
            }

        }else{
println("other request code")
        }
    }


    private fun setUI(){
//        adaptor=ProductAdaptor(list,this)
        recylerView=findViewById(R.id.productList)
        list= ArrayList()
        //List Items
        list.add(User("header",0))
        list.add(User("header",0))
        list.add(User("chat",0))
        list.add(User("checkin",0))
        list.add(User("chat",0))
        list.add(User("checkin",0))
        list.add(User("online",0))
        list.add(User("checkin",0))

        recylerView.setHasFixedSize(true)
        recylerView.layoutManager=LinearLayoutManager(this)
        recylerView.adapter=ProductAdaptor(list,this)


    }


    override fun onItemClickRemove(position: Int) {
        list.remove(list[position])
        adaptor.notifyItemRemoved(position)
    }

    override fun onItemClickItemIncrement(position: Int) {
        list[position].rating++;
        adaptor.notifyItemChanged(position)

    }

    override fun onStart() {
        println("onstart")
        super.onStart()
    }

    override fun onRestart() {
        println("onRestart")

        super.onRestart()
    }

    override fun onResume() {
        println("onResume")

        super.onResume()
    }

    override fun onDestroy() {
        println("onDestroy")

        super.onDestroy()
    }

    override fun onPause() {
        println("onpause")

        super.onPause()
    }
}

data class User(val name: String, var rating: Int)