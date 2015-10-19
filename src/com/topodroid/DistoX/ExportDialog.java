/** @file ExportDialog.java
 *
 * @author marco corvi
 * @date nov 2011
 *
 * @brief TopoDroid survey export dialog
 * --------------------------------------------------------
 *  Copyright This sowftare is distributed under GPL-3.0 or later
 *  See the file COPYING.
 * --------------------------------------------------------
 * CHANGES
 * 20130213 created
 */
package com.topodroid.DistoX;

import android.app.Dialog;
// import android.app.Activity;
import android.os.Bundle;

import android.content.Intent;

import android.content.Context;

import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.view.View;
// import android.view.View.OnKeyListener;
// import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;

import android.util.Log;

public class ExportDialog extends Dialog
                          implements AdapterView.OnItemSelectedListener, View.OnClickListener
{
  private Button   mBtnOk;

  private Context   mContext;
  private IExporter mParent;
  private String[]  mTypes;
  private String    mSelected;
  private int mTitle;

  ExportDialog( Context context, IExporter parent, String[] types, int title )
  {
    super( context );
    mContext = context;
    mParent = parent;
    mTypes  = types;
    mSelected = null;
    mTitle = title;
  }

// -------------------------------------------------------------------
  @Override
  protected void onCreate(Bundle savedInstanceState) 
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.export_dialog);
    getWindow().setLayout( LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT );

    Spinner spin = (Spinner)findViewById( R.id.spin );
    spin.setOnItemSelectedListener( this );
    ArrayAdapter adapter = new ArrayAdapter<String>( mContext, R.layout.menu, mTypes );
    spin.setAdapter( adapter );

    mBtnOk = (Button) findViewById(R.id.button_ok );
    mBtnOk.setOnClickListener( this );

    // Bundle extras = getIntent().getExtras();
    // String title  = extras.getString( TopoDroidApp.TOPODROID_SURVEY );

    setTitle( mTitle );
  }

  public void onItemSelected( AdapterView av, View v, int pos, long id )
  {
    mSelected = mTypes[ pos ];
  }

  public void onNothingSelected( AdapterView av )
  {
    mSelected = null;
  }

  public void onClick(View v) 
  {
    Log.v("DistoX", "Selected " + mSelected );
    if ( (Button)v == mBtnOk && mSelected != null ) {
      mParent.doExport( mSelected );
    // } else if ( b == mBtnCancel ) {
    //   // nothing
    }
    dismiss();
  }

}

