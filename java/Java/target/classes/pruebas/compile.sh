echo "STARTING JFLEX COMPILING"
java -jar "C:\Users\Jonwil\Desktop\jflex y cup\jflex-1.9.1\lib\jflex-full-1.9.1.jar" -d "..\..\java\com\wilsoncys\compi1\javacraft\analizadores\" LexerJavaCraft.jflex

echo "STARTING CUP COMPILING"
java -jar "C:\Users\Jonwil\Desktop\jflex y cup\java-cup-bin-11b-20160615\java-cup-11b.jar" -parser CupJavaCraft CupJavaCraft.cup

# Mover archivos generados y sobrescribir si existen
Move-Item -Path "CupJavaCraft.java" -Destination "..\..\java\com\wilsoncys\compi1\javacraft\analizadores\CupJavaCraft.java" -Force
Move-Item -Path "sym.java" -Destination "..\..\java\com\wilsoncys\compi1\javacraft\analizadores\sym.java" -Force