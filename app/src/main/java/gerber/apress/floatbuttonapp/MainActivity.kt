package gerber.apress.floatbuttonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import gerber.apress.floatbuttonapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val rotateOpen by lazy { AnimationUtils.loadAnimation(applicationContext, R.anim.rotate_open_animation) }
    private val rotateClose by lazy { AnimationUtils.loadAnimation(applicationContext, R.anim.rotate_close_animation) }
    private val toBottom by lazy { AnimationUtils.loadAnimation(applicationContext, R.anim.to_bottom_animation) }
    private val fromBottom by lazy { AnimationUtils.loadAnimation(applicationContext, R.anim.from_bottom_animation) }

    var clicked: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addPhotoButton.setOnClickListener {
            Toast.makeText(binding.root.context, "Dodaj zdjęcie", Toast.LENGTH_SHORT).show()
        }

        binding.recordSoundButton.setOnClickListener {
            Toast.makeText(binding.root.context, "Nagraj notatkę głosową", Toast.LENGTH_SHORT).show()
        }

        binding.addButton.setOnClickListener {
            clicked = !clicked
            setVisibility()
            setAnimation()
        }
    }

    private fun setVisibility() {
        if (clicked){
            binding.addPhotoButton.visibility = View.VISIBLE
            binding.recordSoundButton.visibility = View.VISIBLE
            binding.addPhotoButton.isClickable = true
            binding.recordSoundButton.isClickable = true
        } else {
            binding.addPhotoButton.visibility = View.INVISIBLE
            binding.recordSoundButton.visibility = View.INVISIBLE
            binding.addPhotoButton.isClickable = false
            binding.recordSoundButton.isClickable = false
        }
    }

    private fun setAnimation() {
        if (clicked){
            binding.addButton.startAnimation(rotateOpen)
            binding.recordSoundButton.startAnimation(fromBottom)
            binding.addPhotoButton.startAnimation(fromBottom)
        } else {
            binding.addButton.startAnimation(rotateClose)
            binding.recordSoundButton.startAnimation(toBottom)
            binding.addPhotoButton.startAnimation(toBottom)
        }
    }
}