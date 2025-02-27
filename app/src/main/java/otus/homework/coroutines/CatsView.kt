package otus.homework.coroutines

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.squareup.picasso.Picasso

class CatsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), ICatsView {

    var viewModel :CatsViewModel? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        findViewById<Button>(R.id.button).setOnClickListener {
            viewModel?.onInitComplete()
        }
    }

    override fun populate(model: CatsPresentation) {
        findViewById<TextView>(R.id.fact_textView).text = model.fact.text
        Picasso.get().load(model.imageUrl).into(findViewById<ImageView>(R.id.cats_image_view))
    }

    override fun showToast(message: String) {
        Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
    }
}

interface ICatsView {

    fun populate(model: CatsPresentation)
    fun showToast(message: String)
}