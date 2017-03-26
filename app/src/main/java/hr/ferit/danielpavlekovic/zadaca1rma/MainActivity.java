package hr.ferit.danielpavlekovic.zadaca1rma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvBioMessage;
    ImageButton btnWoz,btnLinus,btnTuring;
    Button btnQuote;

    InspiringPerson Linus = new InspiringPerson();
    InspiringPerson Turing = new InspiringPerson();
    InspiringPerson Woz = new InspiringPerson();

    private void SetPersonDetails(){
        Woz.SetBirth(getResources().getString(R.string.WozBirth));
        Woz.SetTitle(getResources().getString(R.string.WozTitle));
        Woz.SetImage(getResources().getDrawable(R.drawable.woz_img));
        Woz.WriteBio(getResources().getString(R.string.WozBio));
        Turing.SetBirth(getResources().getString(R.string.TuringBirth));
        Turing.SetDeath(getResources().getString(R.string.TuringDeath));
        Turing.SetTitle(getResources().getString(R.string.TuringTitle));
        Turing.SetImage(getResources().getDrawable(R.drawable.turing_img));
        Turing.WriteBio(getResources().getString(R.string.TuringBio));
        Linus.SetBirth(getResources().getString(R.string.LinusBirth));
        Linus.SetTitle(getResources().getString(R.string.LinusTitle));
        Linus.SetImage(getResources().getDrawable(R.drawable.linus_img));
        Linus.WriteBio(getResources().getString(R.string.LinusBio));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InspiringPerson Linus = new InspiringPerson(getResources().getString(R.string.LinusName),getResources().getString(R.string.LinusSurname));
        InspiringPerson Turing = new InspiringPerson(getResources().getString(R.string.TuringName),getResources().getString(R.string.TuringSurname));
        InspiringPerson Woz = new InspiringPerson(getResources().getString(R.string.WozName),getResources().getString(R.string.WozSurname));
        this.SetPersonDetails();
        this.initializeUI();
    }

    private void initializeUI() {
        this.tvBioMessage = (TextView) findViewById(R.id.tvDescription);
        this.btnWoz = (ImageButton) findViewById(R.id.ImBtnWoz);
        this.btnLinus = (ImageButton) findViewById(R.id.ImBtnLinus);
        this.btnTuring = (ImageButton) findViewById(R.id.ImBtnTuring);
        this.btnQuote = (Button) findViewById(R.id.btnQuote);

        this.btnTuring.setOnClickListener(this);
        this.btnWoz.setOnClickListener(this);
        this.btnLinus.setOnClickListener(this);
        this.btnQuote.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case(R.id.ImBtnTuring):
                tvBioMessage.setText(Turing.GetBirthDate() + " " + Turing.GetDeathDate() + " " + Turing.GetBio().toString());
                btnQuote.setVisibility(View.VISIBLE);
                btnQuote.setEnabled(true);
                break;
            case(R.id.ImBtnLinus):
                tvBioMessage.setText(Linus.GetBirthDate() + " " + Linus.GetBio().toString());
                btnQuote.setVisibility(View.VISIBLE);
                btnQuote.setEnabled(true);
                break;
            case(R.id.ImBtnWoz):
                tvBioMessage.setText(Woz.GetBirthDate() + " " + Woz.GetBio().toString());
                btnQuote.setVisibility(View.VISIBLE);
                btnQuote.setEnabled(true);
                break;
            case(R.id.btnQuote):
                this.displayToast("Pozdrav!");
                break;
        }
    }

    private void DescWriteWoz(View view){
        tvBioMessage.setText(Woz.GetBirthDate().toString() + " " + Woz.GetBio().toString());
    }

    private void displayToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}
