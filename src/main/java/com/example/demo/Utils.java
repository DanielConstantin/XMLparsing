package com.example.demo;

import java.io.File;
import java.io.FilenameFilter;

public class Utils {
   static File sourceDir=new File(""); //eTransport - Aprovizionare.xml
   static File destinationDir=new File("");

   static void setInitialPath() {
      System.out.println(sourceDir.getAbsolutePath());
      System.out.println(destinationDir.getAbsolutePath());

   sourceDir = new File(sourceDir.getAbsolutePath()+"\\Sursa");
   destinationDir = new File(destinationDir.getAbsolutePath()+"\\Procesate");

   System.out.println(sourceDir.getAbsolutePath());
   System.out.println(destinationDir.getAbsolutePath());
}
   private static File setFile( String dirName)
   {

      File f;
      File dir = new File(dirName);
      if ( dir.isDirectory() )
      {

         String[] list = dir.list(new FilenameFilter()
         {
            @Override
            public boolean accept(File f, String s )
            {
               return s.endsWith(".xml");
            }

         });

         if ( list.length > 0 )
         {
            // return list[0];
            return new File(list[0]);
         }
      }
      return null;
      // return "";

   }
   static boolean CheckFileExist(){
      File f = setFile(Utils.sourceDir.getAbsolutePath()+"\\");
      System.out.println(f.getAbsolutePath());
      if(!f.getAbsolutePath().equals("null")) {
         Detail.fileCurrent = f.getPath();
         System.out.println(Detail.fileCurrent);
         return true;
      }else return false;
   }
}
