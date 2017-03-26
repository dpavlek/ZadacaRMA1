package hr.ferit.danielpavlekovic.zadaca1rma;


import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.Log;
import android.widget.ImageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by danielpavlekovic on 23.03.2017..
 */

public class InspiringPerson{

    private static final String TAG = "InspiringPerson";

    private String Name;
    private String Surname;
    private Date Birth;
    private Date Death;
    private String Bio;
    private String Title;
    private Drawable PersonImage;
    private SimpleDateFormat dformat = new SimpleDateFormat("dd-MM-yyyy");

    public InspiringPerson(String i_name, String i_surname){
        Name = i_name;
        Surname = i_surname;
    }

    public  InspiringPerson(){

    }

    public void SetBirth(String i_date){
        try{
            Birth=dformat.parse(i_date);
        } catch (ParseException e) {
            Log.e(TAG, "Error parsing date: " + e);
        }
    }

    public void SetDeath(String i_date){
        try{
            Death=dformat.parse(i_date);
        } catch (ParseException e) {
            Log.e(TAG, "Error parsing date: " + e);
        }
    }

    public void SetTitle(String i_title){
        Title=i_title;
    }

    public void WriteBio(String i_bio){
        Bio = i_bio;
    }

    public void SetImage(Drawable i_image){
        i_image=PersonImage;
    }

    public String GetName(){
        return (Name+" "+Surname);
    }

    public Date GetBirthDate(){
        return Birth;
    }

    public Date GetDeathDate(){
        return Death;
    }

    public String GetTitle(){
        return Title;
    }

    public String GetBio(){
        return Bio;
    }

    public Drawable GetImage(){
        return PersonImage;
    }


}
