package com.example.mealsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mealsapp.apimodel.Meal;
import com.example.mealsapp.apimodel.Meals;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private MutableLiveData<String> nome = new MutableLiveData<>();
    private MutableLiveData<String> urlImagem = new MutableLiveData<>();
    private MutableLiveData<String> ingredientes = new MutableLiveData<>();
    private MutableLiveData<String> medicoes = new MutableLiveData<>();
    private MutableLiveData<String> instrucoes = new MutableLiveData<>();

    private TextView mealTitle;
    private TextView mealInstructions;
    private TextView mealIngredients;
    private TextView mealMeasures;
    private ImageView mealImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mealTitle = (TextView) findViewById(R.id.mealTitle);
        mealInstructions = (TextView) findViewById(R.id.mealDesc);
        mealMeasures = (TextView) findViewById(R.id.mealMeasures);
        mealIngredients = (TextView) findViewById(R.id.mealIngredients);
        mealImg = (ImageView) findViewById(R.id.mealImg);

        nome.observe(this,(titulo) -> mealTitle.setText(titulo));
        ingredientes.observe(this,(ing) -> mealIngredients.setText(ing));
        medicoes.observe(this,(med) -> mealMeasures.setText(med));
        instrucoes.observe(this,(ins) -> mealInstructions.setText(ins));

        getUrlImg().observe(this, (img) -> Picasso.get().load(img).into(mealImg));
        MealsApplication app = new MealsApplication();
        app.getExecutor().execute(() -> {
            try {
                Meals ms = app.getMealsRepo().buscar();
                Log.d("teste: ",String.valueOf(app.getMealsRepo().buscar()));
                String strMeal = ms.meals[0].strMeal;
                String strInstrucoes = ms.meals[0].strInstructions;
                String urlMeal = ms.meals[0].strMealThumb;

                String strIngredientes = ms.meals[0].strIngredient1+" \n";
                strIngredientes+=ms.meals[0].strIngredient2+" \n";
                strIngredientes+=ms.meals[0].strIngredient3+" \n";
                strIngredientes+=ms.meals[0].strIngredient4+" \n";
                strIngredientes+=ms.meals[0].strIngredient5+" \n";
                strIngredientes+=ms.meals[0].strIngredient6+" \n";
                strIngredientes+=ms.meals[0].strIngredient7+" \n";
                strIngredientes+=ms.meals[0].strIngredient8+" \n";
                strIngredientes+=ms.meals[0].strIngredient9+" \n";
                strIngredientes+=ms.meals[0].strIngredient10+" \n";
                strIngredientes+=ms.meals[0].strIngredient11+" \n";
                strIngredientes+=ms.meals[0].strIngredient12+" \n";
                strIngredientes+=ms.meals[0].strIngredient13+" \n";
                strIngredientes+=ms.meals[0].strIngredient14+" \n";
                strIngredientes+=ms.meals[0].strIngredient15+" \n";
                strIngredientes+=ms.meals[0].strIngredient16+" \n";
                strIngredientes+=ms.meals[0].strIngredient17+" \n";
                strIngredientes+=ms.meals[0].strIngredient18+" \n";
                strIngredientes+=ms.meals[0].strIngredient19+" \n";
                strIngredientes+=ms.meals[0].strIngredient20+" \n";

                String strMedicoes = ms.meals[0].strMeasure1+" \n";
                strMedicoes+=ms.meals[0].strMeasure2+" \n";
                strMedicoes+=ms.meals[0].strMeasure3+" \n";
                strMedicoes+=ms.meals[0].strMeasure4+" \n";
                strMedicoes+=ms.meals[0].strMeasure5+" \n";
                strMedicoes+=ms.meals[0].strMeasure6+" \n";
                strMedicoes+=ms.meals[0].strMeasure7+" \n";
                strMedicoes+=ms.meals[0].strMeasure8+" \n";
                strMedicoes+=ms.meals[0].strMeasure9+" \n";
                strMedicoes+=ms.meals[0].strMeasure10+" \n";
                strMedicoes+=ms.meals[0].strMeasure11+" \n";
                strMedicoes+=ms.meals[0].strMeasure12+" \n";
                strMedicoes+=ms.meals[0].strMeasure13+" \n";
                strMedicoes+=ms.meals[0].strMeasure14+" \n";
                strMedicoes+=ms.meals[0].strMeasure15+" \n";
                strMedicoes+=ms.meals[0].strMeasure16+" \n";
                strMedicoes+=ms.meals[0].strMeasure17+" \n";
                strMedicoes+=ms.meals[0].strMeasure18+" \n";
                strMedicoes+=ms.meals[0].strMeasure19+" \n";
                strMedicoes+=ms.meals[0].strMeasure20+" \n";


                nome.postValue(strMeal);
                ingredientes.postValue(strIngredientes);
                medicoes.postValue(strMedicoes);
                urlImagem.postValue(urlMeal);
                instrucoes.postValue(strInstrucoes);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public LiveData<String> getUrlImg() {
        return urlImagem;
    }




}