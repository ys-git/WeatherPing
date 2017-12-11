package com.example.ys.weather_ping;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Third extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    protected XmlPullParserFactory xmlPullParserFactory;
    protected XmlPullParser parser;
    public String xmlPath;
    public String a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p;
    public int cel;
    public Double cels;
    public String celss,gh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        Bundle bundle=getIntent().getExtras();
        String data=bundle.get("data").toString();
        Switch lx = (Switch) findViewById(R.id.switch1);
        lx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) //Line A
            {
                TextView tn=(TextView) findViewById(R.id.tv2);
                TextView tq=(TextView) findViewById(R.id.tv3);
                if (isChecked) {
                    tn.setText(a);
                    tq.setText("°F");


                } else {
                    tn.setText(gh);
                    tq.setText("°C");

                }
            }
        });

        xmlPath = new String("http://wxdata.weather.com/wxdata/weather/local/" + data + "?cc=*&unit=#Type%23&dayf=6");
        try {
            xmlPullParserFactory = XmlPullParserFactory.newInstance();
            xmlPullParserFactory.setNamespaceAware(false);
            parser = xmlPullParserFactory.newPullParser();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        //lx.setOnClickListener(new View.OnClickListener() {
           /*lx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tn=(TextView) findViewById(R.id.tv2);
                tn.setText(a);
                TextView tq=(TextView) findViewById(R.id.tv3);
                tq.setText("°F");
            }
                              });*/
        BackgroundAsyncTask backgroundAsyncTask = new BackgroundAsyncTask();
        backgroundAsyncTask.execute(xmlPath);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
    private class BackgroundAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            URL url = null;
            String returnedResult = "";
            try {
                url = new URL(params[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection conn = null;
            try {
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000);
                conn.setConnectTimeout(20000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();
                InputStream is = conn.getInputStream();
                parser.setInput(is, null);
                returnedResult = getLoadedXmlValues(parser);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
            return returnedResult;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            if (!s.equals("")) {

                TextView t1=(TextView) findViewById(R.id.tv1);
                t1.setText(o);
                TextView t2=(TextView) findViewById(R.id.tv2);

                cel = Integer.parseInt(a);
                cels=((cel-32)*0.5556);
                Double de = new Double(cels);
                int i = de.intValue();
                celss=Integer.toString(i);
                gh=String.valueOf(celss);
                t2.setText(gh);

                TextView t3=(TextView) findViewById(R.id.tv15);
                t3.setText("Feels Like:" +c +"°F");
                TextView t4=(TextView) findViewById(R.id.tv5);
                t4.setText(b);
                TextView t5=(TextView) findViewById(R.id.tv6);
                t5.setText(p);
                TextView t6=(TextView) findViewById(R.id.tv7);
                t6.setText(k);
                TextView t7=(TextView) findViewById(R.id.tv9);
                t7.setText(c+" °F");
                TextView t8=(TextView) findViewById(R.id.tv11);
                t8.setText(m+" UV");
                TextView t9=(TextView) findViewById(R.id.tv13);
                t9.setText(e+" °C");
                TextView t10=(TextView) findViewById(R.id.tv10);
                t10.setText(d+" %");
                TextView t11=(TextView) findViewById(R.id.tv12);
                t11.setText(f+" psi");
                TextView t12=(TextView) findViewById(R.id.tv14);
                t12.setText(l+" mi");
                TextView t13=(TextView) findViewById(R.id.textView22);
                t13.setText(g);
                TextView t14=(TextView) findViewById(R.id.textView23);
                t14.setText(h);
                TextView t15=(TextView) findViewById(R.id.textView24);
                t15.setText(i+" °S");
                TextView t16=(TextView) findViewById(R.id.textView25);
                t16.setText(j+" °S");
                TextView t17=(TextView) findViewById(R.id.textView28);
                t17.setText(n);
            }
        }
        private String getLoadedXmlValues(XmlPullParser parser) throws XmlPullParserException, IOException {
            int eventType = parser.getEventType();
            String name = null;
            Entity mEntity = new Entity();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    name = parser.getName();
                    if (name.equals("tmp")) {
                        mEntity.temp = parser.nextText();
                        a=mEntity.temp;
                    } else if (name.equals("dnam")) {
                        mEntity.place = parser.nextText();
                        b=mEntity.place;
                    } else if (name.equals("flik")) {
                        mEntity.feelslike = parser.nextText();
                        c=mEntity.feelslike;
                    } else if (name.equals("hmid")) {
                        mEntity.humidity = parser.nextText();
                        d=mEntity.humidity;
                    } else if (name.equals("dewp")) {
                        mEntity.dewpoint = parser.nextText();
                        e=mEntity.dewpoint;
                    } else if (name.equals("r")) {
                        mEntity.pressure = parser.nextText();
                        f=mEntity.pressure;
                    } else if (name.equals("sunr")) {
                        mEntity.sunrise = parser.nextText();
                        g=mEntity.sunrise;
                    } else if (name.equals("suns")) {
                        mEntity.sunset = parser.nextText();
                        h=mEntity.sunset;
                    } else if (name.equals("lat")) {
                        mEntity.latitude = parser.nextText();
                        i=mEntity.latitude;
                    } else if (name.equals("lon")) {
                        mEntity.longitude = parser.nextText();
                        j=mEntity.longitude;
                    } else if (name.equals("s")) {
                        mEntity.windstate = parser.nextText();
                        k=mEntity.windstate;
                    } else if (name.equals("vis")) {
                        mEntity.visibility = parser.nextText();
                        l=mEntity.visibility;
                    } else if (name.equals("i")) {
                        mEntity.uvindex = parser.nextText();
                        m=mEntity.uvindex;
                    } else if (name.equals("t")) {
                        mEntity.moon = parser.nextText();
                        n=mEntity.moon;
                    } else if (name.equals("tm")) {
                        mEntity.time = parser.nextText();
                        o=mEntity.time;
                    } else if (name.equals("lsup")) {
                        mEntity.date = parser.nextText();
                        p=mEntity.date;
                    }
                }
                eventType = parser.next();
            }
            return mEntity.temp;
        }
        public class Entity {
            public String moon,uvindex,visibility,windstate,longitude,latitude,sunset,
                    sunrise,pressure,dewpoint,humidity,feelslike,place,temp,date,time;
        }
    }
}