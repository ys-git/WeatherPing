package com.example.weatherping;

import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.javatpoint.saxxmlparsing.R;

public class MainActivity extends Activity {
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //tv=(TextView)findViewById(R.id.textView1);
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean tmp = false;
                boolean t = false;

                public void startElement(String uri, String localName,String qName,
                                         Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("tmp")) {
                        tmp = true;
                    }
                    if (qName.equalsIgnoreCase("t")) {
                        t = true;
                    }
                }
                public void endElement(String uri, String localName,
                                       String qName) throws SAXException {
                }
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (tmp) {
                        tv.setText(tv.getText()+"\n\n Temperature is : " + new String(ch, start, length)+"F");
                        tmp = false;
                    }
                    if (t) {
                        tv.setText(tv.getText()+"\n State : " + new String(ch, start, length));
                        t = false;
                    }
                }
            };

            InputStream is = getAssets().open("file.xml");
            saxParser.parse(is, handler);

        } catch (Exception e) {e.printStackTrace();}
    }
}




