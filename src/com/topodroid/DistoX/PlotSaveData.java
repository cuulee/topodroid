/* @file PlotSaveData.java
 *
 * @author marco corvi
 * @date jul 2018
 *
 * @brief TopoDroid sketch saving data struct
 * --------------------------------------------------------
 *  Copyright This software is distributed under GPL-3.0 or later
 *  See the file COPYING.
 * --------------------------------------------------------
 *  @note this object is final because its field are supposed to be accessed read-only
 *        although DistoXNum, PlotInfo, and DrawingCommandManager are references and, therefore,
 *        the underlying object could be changed
 */
package com.topodroid.DistoX;

class PlotSaveData
{
  final PlotInfo plot;
  final long type;
  final DistoXNum num;
  // final DrawingUtil util;
  final DrawingCommandManager cm;
  final String name;
  final String fname;
  final int azimuth;
  final int suffix;
  final int rotate;

  PlotSaveData( DistoXNum n, /* DrawingUtil u, */ PlotInfo p, DrawingCommandManager manager, String nam, String fnam, int a, int s, int r )
  {
    plot = p;
    type = p.type;
    num  = n;
    // util = u;
    cm   = manager;
    name  = nam;
    fname = fnam; // fullname
    azimuth = (int)p.azimuth;
    suffix  = s;
    rotate  = r;
  }
}
