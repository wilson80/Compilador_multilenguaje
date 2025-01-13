#include <iostream>

using namespace std;

int stack[1000];
int heap[1000];
int ptr = 0;
int h = 0;



void java_sumar_sumar(){
int w0;
int w1;
int w2;
int w3;
int w4;
int w5;

w1 = h;
h = w1 + 3;

w2 = ptr + 0;
stack[w2] = w1;

w3 = ptr + 0;
w4 = stack[w3];

w5 = w4 + 2;
heap[w5] =  -1;


retorno0:
    cout<< "";
}

void java_ListaE_ListaE(){
int w8;
int w9;
int w10;
int w11;
int w12;
int w13;
int w14;
int w15;
int w16;
int w17;
int w18;
int w19;
int w20;
int w21;
int w22;

w9 = h;
h = w9 + 4;

w10 = ptr + 0;
stack[w10] = w9;

w11 = ptr + 0;
w12 = stack[w11];

w13 = w12 + 0;
heap[w13] =  -1;


w14 = ptr + 0;
w15 = stack[w14];

w16 = w15 + 1;
heap[w16] =  -1;


w17 = ptr + 0;
w18 = stack[w17];

w19 = w18 + 2;
heap[w19] = 0;


w20 = ptr + 0;
w21 = stack[w20];

w22 = w21 + 3;
heap[w22] = 0;


retorno8:
    cout<< "";
}

void java_Nodo_Nodo(){
int w41;
int w42;
int w43;
int w44;
int w45;
int w46;
int w47;
int w48;
int w49;
int w50;
int w51;
int w52;
int w53;
int w54;
int w55;
int w56;
int w57;

w42 = h;
h = w42 + 3;

w43 = ptr + 0;
stack[w43] = w42;

w44 = ptr + 0;
w45 = stack[w44];

w46 = w45 + 0;
heap[w46] = 0;


w47 = ptr + 0;
w48 = stack[w47];

w49 = w48 + 1;
heap[w49] =  -1;


w50 = ptr + 0;
w51 = stack[w50];

w52 = w51 + 2;
heap[w52] =  -1;


w53 = ptr + 2;
w54 = stack[w53];

w55 = ptr + 0;
w56 = stack[w55];

w57 = w56 + 0;
heap[w57] = w54;


retorno41:
    cout<< "";
}

void java_Nodo_setSiguiente(){
int w89;
int w90;
int w91;
int w92;
int w93;
int w94;

w90 = ptr + 2;
w91 = stack[w90];

w92 = ptr + 0;
w93 = stack[w92];

w94 = w93 + 1;
heap[w94] = w91;


retorno89:
    cout<< " ";
}

void java_Nodo_setAnterior(){
int w104;
int w105;
int w106;
int w107;
int w108;
int w109;

w105 = ptr + 2;
w106 = stack[w105];

w107 = ptr + 0;
w108 = stack[w107];

w109 = w108 + 2;
heap[w109] = w106;


retorno104:
    cout<< " ";
}

void java_ListaE_agregar(){
int w36;
int w37;
int w38;
int w39;
int w40;
int w41;
int w42;
int w43;
int w44;
int w45;
int w46;
int w47;
int w48;
int w49;
int w50;
int w51;
int w52;
int w53;
int w54;
int w55;
int w56;
int w57;
int w58;
int w59;
int w60;
int w61;
int w62;
int w63;
int w64;
int w65;
int w66;
int w67;
int w68;
int w69;
int w70;
int w71;
int w72;
int w73;
int w74;
int w75;
int w76;
int w77;
int w78;
int w79;
int w80;
int w81;
int w82;
int w83;
int w84;
int w85;
int w86;
int w87;
int w88;
int w89;
int w90;
int w91;
int w92;
int w93;
int w94;
int w95;
int w96;
int w97;
int w98;
int w99;
int w100;
int w101;
int w102;
int w103;
int w104;
int w105;
int w106;
int w107;
int w108;
int w109;
int w110;
int w111;
int w112;
int w113;
int w114;
int w115;
int w116;
int w117;
int w118;
int w119;
int w120;
int w121;
int w122;
int w123;

w37 = ptr + 2;
w38 = stack[w37];

w39 = ptr + 4;

w40 = w39 + 2;
stack[w40] = w38;

ptr = ptr + 4;
java_Nodo_Nodo();
ptr = ptr - 4;
w58 = ptr + 4;

w59 = w58 + 0;
w60 = stack[w59];

w61 = ptr + 3;
stack[w61] = w60;

w66 = ptr + 0;
w67 = stack[w66];

w68 = w67 + 0;
w69 = heap[w68];

if(w69== -1)goto if62;
goto else64;
if62:
cout<<"agregando el primero";
cout<<endl;
w70 = ptr + 3;
w71 = stack[w70];

w72 = ptr + 0;
w73 = stack[w72];

w74 = w73 + 0;
heap[w74] = w71;


w75 = ptr + 3;
w76 = stack[w75];

w77 = ptr + 0;
w78 = stack[w77];

w79 = w78 + 1;
heap[w79] = w76;



goto salida63;
else64:
cout<<"agregando el otro";
cout<<endl;
w80 = ptr + 0;
w81 = stack[w80];

w82 = w81 + 1;
w83 = heap[w82];

w84 = ptr + 3;
w85 = stack[w84];

w86 = ptr + 4;

w87 = w86 + 0;
stack[w87] = w83;

w88 = w86 + 2;
stack[w88] = w85;

ptr = ptr + 4;
java_Nodo_setSiguiente();
ptr = ptr - 4;
w95 = ptr + 3;
w96 = stack[w95];

w97 = ptr + 0;
w98 = stack[w97];

w99 = w98 + 1;
w100 = heap[w99];

w101 = ptr + 4;

w102 = w101 + 0;
stack[w102] = w96;

w103 = w101 + 2;
stack[w103] = w100;

ptr = ptr + 4;
java_Nodo_setAnterior();
ptr = ptr - 4;
w110 = ptr + 3;
w111 = stack[w110];

w112 = ptr + 0;
w113 = stack[w112];

w114 = w113 + 1;
heap[w114] = w111;



salida63:
w115 = ptr + 0;
w116 = stack[w115];

w117 = w116 + 2;
w118 = heap[w117];

w119 = 1;

w120 = w118+w119;
w121 = ptr + 0;
w122 = stack[w121];

w123 = w122 + 2;
heap[w123] = w120;


retorno36:
    cout<< " ";
}

void java_Nodo_getContenido(){
int w804;
int w805;
int w806;
int w807;
int w808;
int w809;

w805 = ptr + 0;
w806 = stack[w805];

w807 = w806 + 0;
w808 = heap[w807];

w809 = ptr + 1;
stack[w809] = w808;

goto retorno804;
retorno804:
    cout<< "";
}

void java_Nodo_getSiguiente(){
int w817;
int w818;
int w819;
int w820;
int w821;
int w822;

w818 = ptr + 0;
w819 = stack[w818];

w820 = w819 + 1;
w821 = heap[w820];

w822 = ptr + 1;
stack[w822] = w821;

goto retorno817;
retorno817:
    cout<< "";
}

void java_ListaE_imprimirLista(){
int w781;
int w782;
int w783;
int w784;
int w785;
int w786;
int w787;
int w788;
int w789;
int w790;
int w791;
int w792;
int w793;
int w794;
int w795;
int w796;
int w797;
int w798;
int w799;
int w800;
int w801;
int w802;
int w803;
int w804;
int w805;
int w806;
int w807;
int w808;
int w809;
int w810;
int w811;
int w812;
int w813;
int w814;
int w815;
int w816;
int w817;
int w818;
int w819;
int w820;
int w821;
int w822;
int w823;
int w824;
int w825;
int w826;
int w827;
int w828;
int w829;
int w830;
int w831;
int w832;
int w833;

w782 = ptr + 0;
w783 = stack[w782];

w784 = w783 + 0;
w785 = heap[w784];

w786 = ptr + 2;
stack[w786] = w785;

w787 = 0;

w788 = ptr + 3;
stack[w788] = w787;

w792 = 0;

w793 = ptr + 3;
stack[w793] = w792;


label_Loop789:{}
w794 = ptr + 3;
w795 = stack[w794];

w796 = ptr + 0;
w797 = stack[w796];

w798 = w797 + 2;
w799 = heap[w798];

if(w795<w799)goto label_ins791;
goto salida790;
label_ins791:{}
cout<<"contenido: ";
w800 = ptr + 2;
w801 = stack[w800];

w802 = ptr + 4;

w803 = w802 + 0;
stack[w803] = w801;

ptr = ptr + 4;
java_Nodo_getContenido();
ptr = ptr - 4;

//retorno
w810 = ptr + 4;

w811 = w810 + 1;
w812 = stack[w811];


//retorno
cout<<w812;
cout<<endl;
w813 = ptr + 2;
w814 = stack[w813];

w815 = ptr + 4;

w816 = w815 + 0;
stack[w816] = w814;

ptr = ptr + 4;
java_Nodo_getSiguiente();
ptr = ptr - 4;

//retorno
w823 = ptr + 4;

w824 = w823 + 1;
w825 = stack[w824];


//retorno
w826 = w825;

w827 = ptr + 2;
stack[w827] = w826;


w828 = ptr + 3;
w829 = stack[w828];

w830 = 1;

w831 = w829+w830;
w832 = w831;

w833 = ptr + 3;
stack[w833] = w832;


goto label_Loop789;
salida790:{}
retorno781:
    cout<< " ";
}

void java_Nodo_getAnterior(){
int w870;
int w871;
int w872;
int w873;
int w874;
int w875;

w871 = ptr + 0;
w872 = stack[w871];

w873 = w872 + 2;
w874 = heap[w873];

w875 = ptr + 1;
stack[w875] = w874;

goto retorno870;
retorno870:
    cout<< "";
}

void java_ListaE_eliminarUltimo(){
int w840;
int w841;
int w842;
int w843;
int w844;
int w845;
int w846;
int w847;
int w848;
int w849;
int w850;
int w851;
int w852;
int w853;
int w854;
int w855;
int w856;
int w857;
int w858;
int w859;
int w860;
int w861;
int w862;
int w863;
int w864;
int w865;
int w866;
int w867;
int w868;
int w869;
int w870;
int w871;
int w872;
int w873;
int w874;
int w875;
int w876;
int w877;
int w878;
int w879;
int w880;
int w881;
int w882;
int w883;
int w884;
int w885;
int w886;
int w887;
int w888;
int w889;
int w890;
int w891;
int w892;
int w893;
int w894;
int w895;
int w896;
int w897;
int w898;
int w899;
int w900;
int w901;
int w902;
int w903;
int w904;
int w905;
int w906;

w841 = ptr + 2;
stack[w841] =  -1;

w846 = ptr + 0;
w847 = stack[w846];

w848 = w847 + 0;
w849 = heap[w848];

if(w849== -1)goto if842;
goto else844;
if842:
cout<<"La lista esta vacia";
cout<<endl;

goto salida843;
else844:
w854 = ptr + 0;
w855 = stack[w854];

w856 = w855 + 2;
w857 = heap[w856];

if(w857==1)goto if850;
goto else852;
if850:
w858 = ptr + 0;
w859 = stack[w858];

w860 = w859 + 0;
heap[w860] =  -1;


w861 = ptr + 0;
w862 = stack[w861];

w863 = w862 + 1;
heap[w863] =  -1;



goto salida851;
else852:
w864 = ptr + 0;
w865 = stack[w864];

w866 = w865 + 1;
w867 = heap[w866];

w868 = ptr + 3;

w869 = w868 + 0;
stack[w869] = w867;

ptr = ptr + 3;
java_Nodo_getAnterior();
ptr = ptr - 3;

//retorno
w876 = ptr + 3;

w877 = w876 + 1;
w878 = stack[w877];


//retorno
w879 = w878;

w880 = ptr + 2;
stack[w880] = w879;


w881 = ptr + 2;
w882 = stack[w881];

w883 = ptr + 3;

w884 = w883 + 0;
stack[w884] = w882;

w885 = w883 + 0;
stack[w885] =  -1;

ptr = ptr + 3;
java_Nodo_setSiguiente();
ptr = ptr - 3;
w886 = ptr + 0;
w887 = stack[w886];

w888 = w887 + 1;
w889 = heap[w888];

w890 = ptr + 3;

w891 = w890 + 0;
stack[w891] = w889;

w892 = w890 + 0;
stack[w892] =  -1;

ptr = ptr + 3;
java_Nodo_setAnterior();
ptr = ptr - 3;
w893 = ptr + 2;
w894 = stack[w893];

w895 = ptr + 0;
w896 = stack[w895];

w897 = w896 + 1;
heap[w897] = w894;



salida851:
w898 = ptr + 0;
w899 = stack[w898];

w900 = w899 + 2;
w901 = heap[w900];

w902 = 1;

w903 = w901-w902;
w904 = ptr + 0;
w905 = stack[w904];

w906 = w905 + 2;
heap[w906] = w903;



salida843:
retorno840:
    cout<< " ";
}

void java_ListaE_getSize(){
int w1110;
int w1111;
int w1112;
int w1113;
int w1114;
int w1115;

w1111 = ptr + 0;
w1112 = stack[w1111];

w1113 = w1112 + 2;
w1114 = heap[w1113];

w1115 = ptr + 1;
stack[w1115] = w1114;

goto retorno1110;
retorno1110:
    cout<< "";
}

void java_ListaE_obtenerNodoAvanzando(){
int w1180;
int w1181;
int w1182;
int w1183;
int w1184;
int w1185;
int w1186;
int w1187;
int w1188;
int w1189;
int w1190;
int w1191;
int w1192;
int w1193;
int w1194;
int w1195;
int w1196;
int w1197;
int w1198;
int w1199;
int w1200;
int w1201;
int w1202;
int w1203;
int w1204;
int w1205;
int w1206;
int w1207;
int w1208;
int w1209;
int w1210;
int w1211;
int w1212;
int w1213;
int w1214;
int w1215;
int w1216;
int w1217;
int w1218;
int w1219;
int w1220;

w1181 = ptr + 0;
w1182 = stack[w1181];

w1183 = w1182 + 0;
w1184 = heap[w1183];

w1185 = ptr + 4;
stack[w1185] = w1184;

w1186 = 0;

w1187 = ptr + 5;
stack[w1187] = w1186;

w1191 = 0;

w1192 = ptr + 5;
stack[w1192] = w1191;


label_Loop1188:{}
w1193 = ptr + 5;
w1194 = stack[w1193];

w1195 = ptr + 3;
w1196 = stack[w1195];

if(w1194<w1196)goto label_ins1190;
goto salida1189;
label_ins1190:{}
w1197 = ptr + 4;
w1198 = stack[w1197];

w1199 = ptr + 6;

w1200 = w1199 + 0;
stack[w1200] = w1198;

ptr = ptr + 6;
java_Nodo_getSiguiente();
ptr = ptr - 6;

//retorno
w1207 = ptr + 6;

w1208 = w1207 + 1;
w1209 = stack[w1208];


//retorno
w1210 = w1209;

w1211 = ptr + 4;
stack[w1211] = w1210;


w1212 = ptr + 5;
w1213 = stack[w1212];

w1214 = 1;

w1215 = w1213+w1214;
w1216 = w1215;

w1217 = ptr + 5;
stack[w1217] = w1216;


goto label_Loop1188;
salida1189:{}
w1218 = ptr + 4;
w1219 = stack[w1218];

w1220 = ptr + 1;
stack[w1220] = w1219;

goto retorno1180;
retorno1180:
    cout<< "";
}

void java_ListaE_obtenerNodoRetrocediendo(){
int w1232;
int w1233;
int w1234;
int w1235;
int w1236;
int w1237;
int w1238;
int w1239;
int w1240;
int w1241;
int w1242;
int w1243;
int w1244;
int w1245;
int w1246;
int w1247;
int w1248;
int w1249;
int w1250;
int w1251;
int w1252;
int w1253;
int w1254;
int w1255;
int w1256;
int w1257;
int w1258;
int w1259;
int w1260;
int w1261;
int w1262;
int w1263;
int w1264;
int w1265;
int w1266;
int w1267;
int w1268;
int w1269;
int w1270;
int w1271;
int w1272;
int w1273;
int w1274;
int w1275;
int w1276;
int w1277;
int w1278;
int w1279;
int w1280;
int w1281;
int w1282;
int w1283;
int w1284;
int w1285;

w1233 = ptr + 0;
w1234 = stack[w1233];

w1235 = w1234 + 2;
w1236 = heap[w1235];

w1237 = 1;

w1238 = w1236-w1237;
w1239 = ptr + 4;
stack[w1239] = w1238;

w1240 = ptr + 4;
w1241 = stack[w1240];

w1242 = ptr + 3;
w1243 = stack[w1242];

w1244 = w1241-w1243;
w1245 = ptr + 5;
stack[w1245] = w1244;

w1246 = ptr + 0;
w1247 = stack[w1246];

w1248 = w1247 + 1;
w1249 = heap[w1248];

w1250 = ptr + 6;
stack[w1250] = w1249;

w1251 = 0;

w1252 = ptr + 7;
stack[w1252] = w1251;

w1256 = 0;

w1257 = ptr + 7;
stack[w1257] = w1256;


label_Loop1253:{}
w1258 = ptr + 7;
w1259 = stack[w1258];

w1260 = ptr + 5;
w1261 = stack[w1260];

if(w1259<w1261)goto label_ins1255;
goto salida1254;
label_ins1255:{}
w1262 = ptr + 6;
w1263 = stack[w1262];

w1264 = ptr + 8;

w1265 = w1264 + 0;
stack[w1265] = w1263;

ptr = ptr + 8;
java_Nodo_getAnterior();
ptr = ptr - 8;

//retorno
w1272 = ptr + 8;

w1273 = w1272 + 1;
w1274 = stack[w1273];


//retorno
w1275 = w1274;

w1276 = ptr + 6;
stack[w1276] = w1275;


w1277 = ptr + 7;
w1278 = stack[w1277];

w1279 = 1;

w1280 = w1278+w1279;
w1281 = w1280;

w1282 = ptr + 7;
stack[w1282] = w1281;


goto label_Loop1253;
salida1254:{}
w1283 = ptr + 6;
w1284 = stack[w1283];

w1285 = ptr + 1;
stack[w1285] = w1284;

goto retorno1232;
retorno1232:
    cout<< "";
}

void java_ListaE_obtenerNodoPRO(){
int w1134;
int w1135;
int w1136;
int w1137;
int w1138;
int w1139;
int w1140;
int w1141;
int w1142;
int w1143;
int w1144;
int w1145;
int w1146;
int w1147;
int w1148;
int w1149;
int w1150;
int w1151;
int w1152;
int w1153;
int w1154;
int w1155;
int w1156;
int w1157;
int w1158;
int w1159;
int w1160;
int w1161;
int w1162;
int w1163;
int w1164;
int w1165;
int w1166;
int w1167;
int w1168;
int w1169;
int w1170;
int w1171;
int w1172;
int w1173;
int w1174;
int w1175;
int w1176;
int w1177;
int w1178;
int w1179;
int w1180;
int w1181;
int w1182;
int w1183;
int w1184;
int w1185;
int w1186;
int w1187;
int w1188;
int w1189;
int w1190;
int w1191;
int w1192;
int w1193;
int w1194;
int w1195;
int w1196;
int w1197;
int w1198;
int w1199;
int w1200;
int w1201;
int w1202;
int w1203;
int w1204;
int w1205;
int w1206;
int w1207;
int w1208;
int w1209;
int w1210;
int w1211;
int w1212;
int w1213;
int w1214;
int w1215;
int w1216;
int w1217;
int w1218;
int w1219;
int w1220;
int w1221;
int w1222;
int w1223;
int w1224;
int w1225;
int w1226;
int w1227;
int w1228;
int w1229;
int w1230;
int w1231;
int w1232;
int w1233;
int w1234;
int w1235;
int w1236;
int w1237;
int w1238;
int w1239;
int w1240;
int w1241;
int w1242;
int w1243;
int w1244;
int w1245;
int w1246;
int w1247;
int w1248;
int w1249;
int w1250;
int w1251;
int w1252;
int w1253;
int w1254;
int w1255;
int w1256;
int w1257;
int w1258;
int w1259;
int w1260;
int w1261;
int w1262;
int w1263;
int w1264;
int w1265;
int w1266;
int w1267;
int w1268;
int w1269;
int w1270;
int w1271;
int w1272;
int w1273;
int w1274;
int w1275;
int w1276;
int w1277;
int w1278;
int w1279;
int w1280;
int w1281;
int w1282;
int w1283;
int w1284;
int w1285;
int w1286;
int w1287;
int w1288;
int w1289;

w1139 = ptr + 0;
w1140 = stack[w1139];

w1141 = w1140 + 0;
w1142 = heap[w1141];

if(w1142== -1)goto if1135;
goto salida1136;
if1135:
cout<<"La lista esta vacia.";
cout<<endl;
w1143 = ptr + 1;
stack[w1143] =  -1;

goto retorno1134;

goto salida1136;
salida1136:
w1148 = ptr + 3;
w1149 = stack[w1148];

w1150 = ptr + 0;
w1151 = stack[w1150];

w1152 = w1151 + 2;
w1153 = heap[w1152];

w1154 = ptr + 3;
w1155 = stack[w1154];

if(w1149<w1153)goto if1144;
goto cmpOp21156;
cmpOp21156:
if(w1155<0)goto if1144;
goto salida1145;
if1144:
cout<<"El indice esta fuera del tama;o de la lista.";
cout<<endl;
w1157 = ptr + 1;
stack[w1157] =  -1;

goto retorno1134;

goto salida1145;
salida1145:
w1158 = ptr + 0;
w1159 = stack[w1158];

w1160 = w1159 + 2;
w1161 = heap[w1160];

w1162 = 2;

w1163 = w1161/w1162;
w1164 = ptr + 4;
stack[w1164] = w1163;

w1169 = ptr + 3;
w1170 = stack[w1169];

w1171 = ptr + 4;
w1172 = stack[w1171];

if(w1170<w1172)goto if1165;
goto else1167;
if1165:
w1173 = ptr + 3;
w1174 = stack[w1173];

w1175 = ptr + 5;

w1176 = ptr + 0;
w1177 = stack[w1176];

w1178 = w1175 + 0;
stack[w1178] = w1177;

w1179 = w1175 + 3;
stack[w1179] = w1174;

ptr = ptr + 5;
java_ListaE_obtenerNodoAvanzando();
ptr = ptr - 5;

//retorno
w1221 = ptr + 5;

w1222 = w1221 + 1;
w1223 = stack[w1222];


//retorno
w1224 = ptr + 1;
stack[w1224] = w1223;

goto retorno1134;

goto salida1166;
else1167:
w1225 = ptr + 3;
w1226 = stack[w1225];

w1227 = ptr + 5;

w1228 = ptr + 0;
w1229 = stack[w1228];

w1230 = w1227 + 0;
stack[w1230] = w1229;

w1231 = w1227 + 3;
stack[w1231] = w1226;

ptr = ptr + 5;
java_ListaE_obtenerNodoRetrocediendo();
ptr = ptr - 5;

//retorno
w1286 = ptr + 5;

w1287 = w1286 + 1;
w1288 = stack[w1287];


//retorno
w1289 = ptr + 1;
stack[w1289] = w1288;

goto retorno1134;

salida1166:
retorno1134:
    cout<< "";
}

void java_ListaE_getContent(){
int w1126;
int w1127;
int w1128;
int w1129;
int w1130;
int w1131;
int w1132;
int w1133;
int w1134;
int w1135;
int w1136;
int w1137;
int w1138;
int w1139;
int w1140;
int w1141;
int w1142;
int w1143;
int w1144;
int w1145;
int w1146;
int w1147;
int w1148;
int w1149;
int w1150;
int w1151;
int w1152;
int w1153;
int w1154;
int w1155;
int w1156;
int w1157;
int w1158;
int w1159;
int w1160;
int w1161;
int w1162;
int w1163;
int w1164;
int w1165;
int w1166;
int w1167;
int w1168;
int w1169;
int w1170;
int w1171;
int w1172;
int w1173;
int w1174;
int w1175;
int w1176;
int w1177;
int w1178;
int w1179;
int w1180;
int w1181;
int w1182;
int w1183;
int w1184;
int w1185;
int w1186;
int w1187;
int w1188;
int w1189;
int w1190;
int w1191;
int w1192;
int w1193;
int w1194;
int w1195;
int w1196;
int w1197;
int w1198;
int w1199;
int w1200;
int w1201;
int w1202;
int w1203;
int w1204;
int w1205;
int w1206;
int w1207;
int w1208;
int w1209;
int w1210;
int w1211;
int w1212;
int w1213;
int w1214;
int w1215;
int w1216;
int w1217;
int w1218;
int w1219;
int w1220;
int w1221;
int w1222;
int w1223;
int w1224;
int w1225;
int w1226;
int w1227;
int w1228;
int w1229;
int w1230;
int w1231;
int w1232;
int w1233;
int w1234;
int w1235;
int w1236;
int w1237;
int w1238;
int w1239;
int w1240;
int w1241;
int w1242;
int w1243;
int w1244;
int w1245;
int w1246;
int w1247;
int w1248;
int w1249;
int w1250;
int w1251;
int w1252;
int w1253;
int w1254;
int w1255;
int w1256;
int w1257;
int w1258;
int w1259;
int w1260;
int w1261;
int w1262;
int w1263;
int w1264;
int w1265;
int w1266;
int w1267;
int w1268;
int w1269;
int w1270;
int w1271;
int w1272;
int w1273;
int w1274;
int w1275;
int w1276;
int w1277;
int w1278;
int w1279;
int w1280;
int w1281;
int w1282;
int w1283;
int w1284;
int w1285;
int w1286;
int w1287;
int w1288;
int w1289;
int w1290;
int w1291;
int w1292;
int w1293;
int w1294;
int w1295;
int w1296;
int w1297;
int w1298;
int w1299;
int w1300;
int w1301;
int w1302;
int w1303;
int w1304;
int w1305;
int w1306;
int w1307;

w1127 = ptr + 3;
w1128 = stack[w1127];

w1129 = ptr + 5;

w1130 = ptr + 0;
w1131 = stack[w1130];

w1132 = w1129 + 0;
stack[w1132] = w1131;

w1133 = w1129 + 3;
stack[w1133] = w1128;

ptr = ptr + 5;
java_ListaE_obtenerNodoPRO();
ptr = ptr - 5;

//retorno
w1290 = ptr + 5;

w1291 = w1290 + 1;
w1292 = stack[w1291];


//retorno
w1293 = ptr + 4;
stack[w1293] = w1292;

w1294 = ptr + 4;
w1295 = stack[w1294];

w1296 = ptr + 5;

w1297 = w1296 + 0;
stack[w1297] = w1295;

ptr = ptr + 5;
java_Nodo_getContenido();
ptr = ptr - 5;

//retorno
w1304 = ptr + 5;

w1305 = w1304 + 1;
w1306 = stack[w1305];


//retorno
w1307 = ptr + 1;
stack[w1307] = w1306;

goto retorno1126;
retorno1126:
    cout<< "";
}

void java_ListaE_obtenerNodo(){
int w1318;
int w1319;
int w1320;
int w1321;
int w1322;
int w1323;
int w1324;
int w1325;
int w1326;
int w1327;
int w1328;
int w1329;
int w1330;
int w1331;
int w1332;
int w1333;
int w1334;
int w1335;
int w1336;
int w1337;
int w1338;
int w1339;
int w1340;
int w1341;
int w1342;
int w1343;
int w1344;
int w1345;
int w1346;
int w1347;
int w1348;
int w1349;
int w1350;
int w1351;
int w1352;
int w1353;
int w1354;
int w1355;
int w1356;
int w1357;
int w1358;

w1319 = ptr + 0;
w1320 = stack[w1319];

w1321 = w1320 + 0;
w1322 = heap[w1321];

w1323 = ptr + 4;
stack[w1323] = w1322;

w1324 = 0;

w1325 = ptr + 5;
stack[w1325] = w1324;

w1329 = 0;

w1330 = ptr + 5;
stack[w1330] = w1329;


label_Loop1326:{}
w1331 = ptr + 5;
w1332 = stack[w1331];

w1333 = ptr + 3;
w1334 = stack[w1333];

if(w1332<w1334)goto label_ins1328;
goto salida1327;
label_ins1328:{}
w1335 = ptr + 4;
w1336 = stack[w1335];

w1337 = ptr + 6;

w1338 = w1337 + 0;
stack[w1338] = w1336;

ptr = ptr + 6;
java_Nodo_getSiguiente();
ptr = ptr - 6;

//retorno
w1345 = ptr + 6;

w1346 = w1345 + 1;
w1347 = stack[w1346];


//retorno
w1348 = w1347;

w1349 = ptr + 4;
stack[w1349] = w1348;


w1350 = ptr + 5;
w1351 = stack[w1350];

w1352 = 1;

w1353 = w1351+w1352;
w1354 = w1353;

w1355 = ptr + 5;
stack[w1355] = w1354;


goto label_Loop1326;
salida1327:{}
w1356 = ptr + 4;
w1357 = stack[w1356];

w1358 = ptr + 1;
stack[w1358] = w1357;

goto retorno1318;
retorno1318:
    cout<< "";
}

void java_sumar_iniciar(){
int w6;
int w7;
int w8;
int w9;
int w10;
int w11;
int w12;
int w13;
int w14;
int w15;
int w16;
int w17;
int w18;
int w19;
int w20;
int w21;
int w22;
int w23;
int w24;
int w25;
int w26;
int w27;
int w28;
int w29;
int w30;
int w31;
int w32;
int w33;
int w34;
int w35;
int w36;
int w37;
int w38;
int w39;
int w40;
int w41;
int w42;
int w43;
int w44;
int w45;
int w46;
int w47;
int w48;
int w49;
int w50;
int w51;
int w52;
int w53;
int w54;
int w55;
int w56;
int w57;
int w58;
int w59;
int w60;
int w61;
int w62;
int w63;
int w64;
int w65;
int w66;
int w67;
int w68;
int w69;
int w70;
int w71;
int w72;
int w73;
int w74;
int w75;
int w76;
int w77;
int w78;
int w79;
int w80;
int w81;
int w82;
int w83;
int w84;
int w85;
int w86;
int w87;
int w88;
int w89;
int w90;
int w91;
int w92;
int w93;
int w94;
int w95;
int w96;
int w97;
int w98;
int w99;
int w100;
int w101;
int w102;
int w103;
int w104;
int w105;
int w106;
int w107;
int w108;
int w109;
int w110;
int w111;
int w112;
int w113;
int w114;
int w115;
int w116;
int w117;
int w118;
int w119;
int w120;
int w121;
int w122;
int w123;
int w124;
int w125;
int w126;
int w127;
int w128;
int w129;
int w130;
int w131;
int w132;
int w133;
int w134;
int w135;
int w136;
int w137;
int w138;
int w139;
int w140;
int w141;
int w142;
int w143;
int w144;
int w145;
int w146;
int w147;
int w148;
int w149;
int w150;
int w151;
int w152;
int w153;
int w154;
int w155;
int w156;
int w157;
int w158;
int w159;
int w160;
int w161;
int w162;
int w163;
int w164;
int w165;
int w166;
int w167;
int w168;
int w169;
int w170;
int w171;
int w172;
int w173;
int w174;
int w175;
int w176;
int w177;
int w178;
int w179;
int w180;
int w181;
int w182;
int w183;
int w184;
int w185;
int w186;
int w187;
int w188;
int w189;
int w190;
int w191;
int w192;
int w193;
int w194;
int w195;
int w196;
int w197;
int w198;
int w199;
int w200;
int w201;
int w202;
int w203;
int w204;
int w205;
int w206;
int w207;
int w208;
int w209;
int w210;
int w211;
int w212;
int w213;
int w214;
int w215;
int w216;
int w217;
int w218;
int w219;
int w220;
int w221;
int w222;
int w223;
int w224;
int w225;
int w226;
int w227;
int w228;
int w229;
int w230;
int w231;
int w232;
int w233;
int w234;
int w235;
int w236;
int w237;
int w238;
int w239;
int w240;
int w241;
int w242;
int w243;
int w244;
int w245;
int w246;
int w247;
int w248;
int w249;
int w250;
int w251;
int w252;
int w253;
int w254;
int w255;
int w256;
int w257;
int w258;
int w259;
int w260;
int w261;
int w262;
int w263;
int w264;
int w265;
int w266;
int w267;
int w268;
int w269;
int w270;
int w271;
int w272;
int w273;
int w274;
int w275;
int w276;
int w277;
int w278;
int w279;
int w280;
int w281;
int w282;
int w283;
int w284;
int w285;
int w286;
int w287;
int w288;
int w289;
int w290;
int w291;
int w292;
int w293;
int w294;
int w295;
int w296;
int w297;
int w298;
int w299;
int w300;
int w301;
int w302;
int w303;
int w304;
int w305;
int w306;
int w307;
int w308;
int w309;
int w310;
int w311;
int w312;
int w313;
int w314;
int w315;
int w316;
int w317;
int w318;
int w319;
int w320;
int w321;
int w322;
int w323;
int w324;
int w325;
int w326;
int w327;
int w328;
int w329;
int w330;
int w331;
int w332;
int w333;
int w334;
int w335;
int w336;
int w337;
int w338;
int w339;
int w340;
int w341;
int w342;
int w343;
int w344;
int w345;
int w346;
int w347;
int w348;
int w349;
int w350;
int w351;
int w352;
int w353;
int w354;
int w355;
int w356;
int w357;
int w358;
int w359;
int w360;
int w361;
int w362;
int w363;
int w364;
int w365;
int w366;
int w367;
int w368;
int w369;
int w370;
int w371;
int w372;
int w373;
int w374;
int w375;
int w376;
int w377;
int w378;
int w379;
int w380;
int w381;
int w382;
int w383;
int w384;
int w385;
int w386;
int w387;
int w388;
int w389;
int w390;
int w391;
int w392;
int w393;
int w394;
int w395;
int w396;
int w397;
int w398;
int w399;
int w400;
int w401;
int w402;
int w403;
int w404;
int w405;
int w406;
int w407;
int w408;
int w409;
int w410;
int w411;
int w412;
int w413;
int w414;
int w415;
int w416;
int w417;
int w418;
int w419;
int w420;
int w421;
int w422;
int w423;
int w424;
int w425;
int w426;
int w427;
int w428;
int w429;
int w430;
int w431;
int w432;
int w433;
int w434;
int w435;
int w436;
int w437;
int w438;
int w439;
int w440;
int w441;
int w442;
int w443;
int w444;
int w445;
int w446;
int w447;
int w448;
int w449;
int w450;
int w451;
int w452;
int w453;
int w454;
int w455;
int w456;
int w457;
int w458;
int w459;
int w460;
int w461;
int w462;
int w463;
int w464;
int w465;
int w466;
int w467;
int w468;
int w469;
int w470;
int w471;
int w472;
int w473;
int w474;
int w475;
int w476;
int w477;
int w478;
int w479;
int w480;
int w481;
int w482;
int w483;
int w484;
int w485;
int w486;
int w487;
int w488;
int w489;
int w490;
int w491;
int w492;
int w493;
int w494;
int w495;
int w496;
int w497;
int w498;
int w499;
int w500;
int w501;
int w502;
int w503;
int w504;
int w505;
int w506;
int w507;
int w508;
int w509;
int w510;
int w511;
int w512;
int w513;
int w514;
int w515;
int w516;
int w517;
int w518;
int w519;
int w520;
int w521;
int w522;
int w523;
int w524;
int w525;
int w526;
int w527;
int w528;
int w529;
int w530;
int w531;
int w532;
int w533;
int w534;
int w535;
int w536;
int w537;
int w538;
int w539;
int w540;
int w541;
int w542;
int w543;
int w544;
int w545;
int w546;
int w547;
int w548;
int w549;
int w550;
int w551;
int w552;
int w553;
int w554;
int w555;
int w556;
int w557;
int w558;
int w559;
int w560;
int w561;
int w562;
int w563;
int w564;
int w565;
int w566;
int w567;
int w568;
int w569;
int w570;
int w571;
int w572;
int w573;
int w574;
int w575;
int w576;
int w577;
int w578;
int w579;
int w580;
int w581;
int w582;
int w583;
int w584;
int w585;
int w586;
int w587;
int w588;
int w589;
int w590;
int w591;
int w592;
int w593;
int w594;
int w595;
int w596;
int w597;
int w598;
int w599;
int w600;
int w601;
int w602;
int w603;
int w604;
int w605;
int w606;
int w607;
int w608;
int w609;
int w610;
int w611;
int w612;
int w613;
int w614;
int w615;
int w616;
int w617;
int w618;
int w619;
int w620;
int w621;
int w622;
int w623;
int w624;
int w625;
int w626;
int w627;
int w628;
int w629;
int w630;
int w631;
int w632;
int w633;
int w634;
int w635;
int w636;
int w637;
int w638;
int w639;
int w640;
int w641;
int w642;
int w643;
int w644;
int w645;
int w646;
int w647;
int w648;
int w649;
int w650;
int w651;
int w652;
int w653;
int w654;
int w655;
int w656;
int w657;
int w658;
int w659;
int w660;
int w661;
int w662;
int w663;
int w664;
int w665;
int w666;
int w667;
int w668;
int w669;
int w670;
int w671;
int w672;
int w673;
int w674;
int w675;
int w676;
int w677;
int w678;
int w679;
int w680;
int w681;
int w682;
int w683;
int w684;
int w685;
int w686;
int w687;
int w688;
int w689;
int w690;
int w691;
int w692;
int w693;
int w694;
int w695;
int w696;
int w697;
int w698;
int w699;
int w700;
int w701;
int w702;
int w703;
int w704;
int w705;
int w706;
int w707;
int w708;
int w709;
int w710;
int w711;
int w712;
int w713;
int w714;
int w715;
int w716;
int w717;
int w718;
int w719;
int w720;
int w721;
int w722;
int w723;
int w724;
int w725;
int w726;
int w727;
int w728;
int w729;
int w730;
int w731;
int w732;
int w733;
int w734;
int w735;
int w736;
int w737;
int w738;
int w739;
int w740;
int w741;
int w742;
int w743;
int w744;
int w745;
int w746;
int w747;
int w748;
int w749;
int w750;
int w751;
int w752;
int w753;
int w754;
int w755;
int w756;
int w757;
int w758;
int w759;
int w760;
int w761;
int w762;
int w763;
int w764;
int w765;
int w766;
int w767;
int w768;
int w769;
int w770;
int w771;
int w772;
int w773;
int w774;
int w775;
int w776;
int w777;
int w778;
int w779;
int w780;
int w781;
int w782;
int w783;
int w784;
int w785;
int w786;
int w787;
int w788;
int w789;
int w790;
int w791;
int w792;
int w793;
int w794;
int w795;
int w796;
int w797;
int w798;
int w799;
int w800;
int w801;
int w802;
int w803;
int w804;
int w805;
int w806;
int w807;
int w808;
int w809;
int w810;
int w811;
int w812;
int w813;
int w814;
int w815;
int w816;
int w817;
int w818;
int w819;
int w820;
int w821;
int w822;
int w823;
int w824;
int w825;
int w826;
int w827;
int w828;
int w829;
int w830;
int w831;
int w832;
int w833;
int w834;
int w835;
int w836;
int w837;
int w838;
int w839;
int w840;
int w841;
int w842;
int w843;
int w844;
int w845;
int w846;
int w847;
int w848;
int w849;
int w850;
int w851;
int w852;
int w853;
int w854;
int w855;
int w856;
int w857;
int w858;
int w859;
int w860;
int w861;
int w862;
int w863;
int w864;
int w865;
int w866;
int w867;
int w868;
int w869;
int w870;
int w871;
int w872;
int w873;
int w874;
int w875;
int w876;
int w877;
int w878;
int w879;
int w880;
int w881;
int w882;
int w883;
int w884;
int w885;
int w886;
int w887;
int w888;
int w889;
int w890;
int w891;
int w892;
int w893;
int w894;
int w895;
int w896;
int w897;
int w898;
int w899;
int w900;
int w901;
int w902;
int w903;
int w904;
int w905;
int w906;
int w907;
int w908;
int w909;
int w910;
int w911;
int w912;
int w913;
int w914;
int w915;
int w916;
int w917;
int w918;
int w919;
int w920;
int w921;
int w922;
int w923;
int w924;
int w925;
int w926;
int w927;
int w928;
int w929;
int w930;
int w931;
int w932;
int w933;
int w934;
int w935;
int w936;
int w937;
int w938;
int w939;
int w940;
int w941;
int w942;
int w943;
int w944;
int w945;
int w946;
int w947;
int w948;
int w949;
int w950;
int w951;
int w952;
int w953;
int w954;
int w955;
int w956;
int w957;
int w958;
int w959;
int w960;
int w961;
int w962;
int w963;
int w964;
int w965;
int w966;
int w967;
int w968;
int w969;
int w970;
int w971;
int w972;
int w973;
int w974;
int w975;
int w976;
int w977;
int w978;
int w979;
int w980;
int w981;
int w982;
int w983;
int w984;
int w985;
int w986;
int w987;
int w988;
int w989;
int w990;
int w991;
int w992;
int w993;
int w994;
int w995;
int w996;
int w997;
int w998;
int w999;
int w1000;
int w1001;
int w1002;
int w1003;
int w1004;
int w1005;
int w1006;
int w1007;
int w1008;
int w1009;
int w1010;
int w1011;
int w1012;
int w1013;
int w1014;
int w1015;
int w1016;
int w1017;
int w1018;
int w1019;
int w1020;
int w1021;
int w1022;
int w1023;
int w1024;
int w1025;
int w1026;
int w1027;
int w1028;
int w1029;
int w1030;
int w1031;
int w1032;
int w1033;
int w1034;
int w1035;
int w1036;
int w1037;
int w1038;
int w1039;
int w1040;
int w1041;
int w1042;
int w1043;
int w1044;
int w1045;
int w1046;
int w1047;
int w1048;
int w1049;
int w1050;
int w1051;
int w1052;
int w1053;
int w1054;
int w1055;
int w1056;
int w1057;
int w1058;
int w1059;
int w1060;
int w1061;
int w1062;
int w1063;
int w1064;
int w1065;
int w1066;
int w1067;
int w1068;
int w1069;
int w1070;
int w1071;
int w1072;
int w1073;
int w1074;
int w1075;
int w1076;
int w1077;
int w1078;
int w1079;
int w1080;
int w1081;
int w1082;
int w1083;
int w1084;
int w1085;
int w1086;
int w1087;
int w1088;
int w1089;
int w1090;
int w1091;
int w1092;
int w1093;
int w1094;
int w1095;
int w1096;
int w1097;
int w1098;
int w1099;
int w1100;
int w1101;
int w1102;
int w1103;
int w1104;
int w1105;
int w1106;
int w1107;
int w1108;
int w1109;
int w1110;
int w1111;
int w1112;
int w1113;
int w1114;
int w1115;
int w1116;
int w1117;
int w1118;
int w1119;
int w1120;
int w1121;
int w1122;
int w1123;
int w1124;
int w1125;
int w1126;
int w1127;
int w1128;
int w1129;
int w1130;
int w1131;
int w1132;
int w1133;
int w1134;
int w1135;
int w1136;
int w1137;
int w1138;
int w1139;
int w1140;
int w1141;
int w1142;
int w1143;
int w1144;
int w1145;
int w1146;
int w1147;
int w1148;
int w1149;
int w1150;
int w1151;
int w1152;
int w1153;
int w1154;
int w1155;
int w1156;
int w1157;
int w1158;
int w1159;
int w1160;
int w1161;
int w1162;
int w1163;
int w1164;
int w1165;
int w1166;
int w1167;
int w1168;
int w1169;
int w1170;
int w1171;
int w1172;
int w1173;
int w1174;
int w1175;
int w1176;
int w1177;
int w1178;
int w1179;
int w1180;
int w1181;
int w1182;
int w1183;
int w1184;
int w1185;
int w1186;
int w1187;
int w1188;
int w1189;
int w1190;
int w1191;
int w1192;
int w1193;
int w1194;
int w1195;
int w1196;
int w1197;
int w1198;
int w1199;
int w1200;
int w1201;
int w1202;
int w1203;
int w1204;
int w1205;
int w1206;
int w1207;
int w1208;
int w1209;
int w1210;
int w1211;
int w1212;
int w1213;
int w1214;
int w1215;
int w1216;
int w1217;
int w1218;
int w1219;
int w1220;
int w1221;
int w1222;
int w1223;
int w1224;
int w1225;
int w1226;
int w1227;
int w1228;
int w1229;
int w1230;
int w1231;
int w1232;
int w1233;
int w1234;
int w1235;
int w1236;
int w1237;
int w1238;
int w1239;
int w1240;
int w1241;
int w1242;
int w1243;
int w1244;
int w1245;
int w1246;
int w1247;
int w1248;
int w1249;
int w1250;
int w1251;
int w1252;
int w1253;
int w1254;
int w1255;
int w1256;
int w1257;
int w1258;
int w1259;
int w1260;
int w1261;
int w1262;
int w1263;
int w1264;
int w1265;
int w1266;
int w1267;
int w1268;
int w1269;
int w1270;
int w1271;
int w1272;
int w1273;
int w1274;
int w1275;
int w1276;
int w1277;
int w1278;
int w1279;
int w1280;
int w1281;
int w1282;
int w1283;
int w1284;
int w1285;
int w1286;
int w1287;
int w1288;
int w1289;
int w1290;
int w1291;
int w1292;
int w1293;
int w1294;
int w1295;
int w1296;
int w1297;
int w1298;
int w1299;
int w1300;
int w1301;
int w1302;
int w1303;
int w1304;
int w1305;
int w1306;
int w1307;
int w1308;
int w1309;
int w1310;
int w1311;
int w1312;
int w1313;
int w1314;
int w1315;
int w1316;
int w1317;
int w1318;
int w1319;
int w1320;
int w1321;
int w1322;
int w1323;
int w1324;
int w1325;
int w1326;
int w1327;
int w1328;
int w1329;
int w1330;
int w1331;
int w1332;
int w1333;
int w1334;
int w1335;
int w1336;
int w1337;
int w1338;
int w1339;
int w1340;
int w1341;
int w1342;
int w1343;
int w1344;
int w1345;
int w1346;
int w1347;
int w1348;
int w1349;
int w1350;
int w1351;
int w1352;
int w1353;
int w1354;
int w1355;
int w1356;
int w1357;
int w1358;
int w1359;
int w1360;
int w1361;
int w1362;
int w1363;
int w1364;
int w1365;
int w1366;
int w1367;
int w1368;
int w1369;
int w1370;
int w1371;
int w1372;
int w1373;
int w1374;
int w1375;

w7 = ptr + 3;

ptr = ptr + 3;
java_ListaE_ListaE();
ptr = ptr - 3;
w23 = ptr + 3;

w24 = w23 + 0;
w25 = stack[w24];

w26 = ptr + 0;
w27 = stack[w26];

w28 = w27 + 2;
heap[w28] = w25;


w29 = ptr + 0;
w30 = stack[w29];

w31 = w30 + 2;
w32 = heap[w31];

w33 = ptr + 3;

w34 = w33 + 0;
stack[w34] = w32;

w35 = w33 + 2;
stack[w35] = 71;

ptr = ptr + 3;
java_ListaE_agregar();
ptr = ptr - 3;
w124 = ptr + 0;
w125 = stack[w124];

w126 = w125 + 2;
w127 = heap[w126];

w128 = ptr + 3;

w129 = w128 + 0;
stack[w129] = w127;

w130 = w128 + 2;
stack[w130] = 72;

ptr = ptr + 3;
java_ListaE_agregar();
ptr = ptr - 3;
w217 = ptr + 0;
w218 = stack[w217];

w219 = w218 + 2;
w220 = heap[w219];

w221 = ptr + 3;

w222 = w221 + 0;
stack[w222] = w220;

w223 = w221 + 2;
stack[w223] = 73;

ptr = ptr + 3;
java_ListaE_agregar();
ptr = ptr - 3;
w310 = ptr + 0;
w311 = stack[w310];

w312 = w311 + 2;
w313 = heap[w312];

w314 = ptr + 3;

w315 = w314 + 0;
stack[w315] = w313;

w316 = w314 + 2;
stack[w316] = 74;

ptr = ptr + 3;
java_ListaE_agregar();
ptr = ptr - 3;
w403 = ptr + 0;
w404 = stack[w403];

w405 = w404 + 2;
w406 = heap[w405];

w407 = ptr + 3;

w408 = w407 + 0;
stack[w408] = w406;

w409 = w407 + 2;
stack[w409] = 75;

ptr = ptr + 3;
java_ListaE_agregar();
ptr = ptr - 3;
w496 = ptr + 0;
w497 = stack[w496];

w498 = w497 + 2;
w499 = heap[w498];

w500 = ptr + 3;

w501 = w500 + 0;
stack[w501] = w499;

w502 = w500 + 2;
stack[w502] = 76;

ptr = ptr + 3;
java_ListaE_agregar();
ptr = ptr - 3;
w589 = ptr + 0;
w590 = stack[w589];

w591 = w590 + 2;
w592 = heap[w591];

w593 = ptr + 3;

w594 = w593 + 0;
stack[w594] = w592;

w595 = w593 + 2;
stack[w595] = 77;

ptr = ptr + 3;
java_ListaE_agregar();
ptr = ptr - 3;
w682 = ptr + 0;
w683 = stack[w682];

w684 = w683 + 2;
w685 = heap[w684];

w686 = ptr + 3;

w687 = w686 + 0;
stack[w687] = w685;

w688 = w686 + 2;
stack[w688] = 78;

ptr = ptr + 3;
java_ListaE_agregar();
ptr = ptr - 3;
w775 = ptr + 0;
w776 = stack[w775];

w777 = w776 + 2;
w778 = heap[w777];

w779 = ptr + 3;

w780 = w779 + 0;
stack[w780] = w778;

ptr = ptr + 3;
java_ListaE_imprimirLista();
ptr = ptr - 3;
cout<<"eliminando algunos:  ";
cout<<endl;
w834 = ptr + 0;
w835 = stack[w834];

w836 = w835 + 2;
w837 = heap[w836];

w838 = ptr + 3;

w839 = w838 + 0;
stack[w839] = w837;

ptr = ptr + 3;
java_ListaE_eliminarUltimo();
ptr = ptr - 3;
w907 = ptr + 0;
w908 = stack[w907];

w909 = w908 + 2;
w910 = heap[w909];

w911 = ptr + 3;

w912 = w911 + 0;
stack[w912] = w910;

ptr = ptr + 3;
java_ListaE_eliminarUltimo();
ptr = ptr - 3;
w976 = ptr + 0;
w977 = stack[w976];

w978 = w977 + 2;
w979 = heap[w978];

w980 = ptr + 3;

w981 = w980 + 0;
stack[w981] = w979;

ptr = ptr + 3;
java_ListaE_eliminarUltimo();
ptr = ptr - 3;
w1045 = ptr + 0;
w1046 = stack[w1045];

w1047 = w1046 + 2;
w1048 = heap[w1047];

w1049 = ptr + 3;

w1050 = w1049 + 0;
stack[w1050] = w1048;

ptr = ptr + 3;
java_ListaE_imprimirLista();
ptr = ptr - 3;
cout<<"lista: ";
w1104 = ptr + 0;
w1105 = stack[w1104];

w1106 = w1105 + 2;
w1107 = heap[w1106];

w1108 = ptr + 3;

w1109 = w1108 + 0;
stack[w1109] = w1107;

ptr = ptr + 3;
java_ListaE_getSize();
ptr = ptr - 3;

//retorno
w1116 = ptr + 3;

w1117 = w1116 + 1;
w1118 = stack[w1117];


//retorno
cout<<w1118;
cout<<endl;
cout<<"obtener modo pro pos(5): ";
w1119 = ptr + 0;
w1120 = stack[w1119];

w1121 = w1120 + 2;
w1122 = heap[w1121];

w1123 = ptr + 3;

w1124 = w1123 + 0;
stack[w1124] = w1122;

w1125 = w1123 + 3;
stack[w1125] = 5;

ptr = ptr + 3;
java_ListaE_getContent();
ptr = ptr - 3;

//retorno
w1308 = ptr + 3;

w1309 = w1308 + 1;
w1310 = stack[w1309];


//retorno
cout<<w1310;
cout<<endl;
w1311 = ptr + 0;
w1312 = stack[w1311];

w1313 = w1312 + 2;
w1314 = heap[w1313];

w1315 = ptr + 3;

w1316 = w1315 + 0;
stack[w1316] = w1314;

w1317 = w1315 + 3;
stack[w1317] = 3;

ptr = ptr + 3;
java_ListaE_obtenerNodo();
ptr = ptr - 3;

//retorno
w1359 = ptr + 3;

w1360 = w1359 + 1;
w1361 = stack[w1360];


//retorno
w1362 = ptr + 2;
stack[w1362] = w1361;

cout<<"obteniendo contenido de un nodo: en pos 3: ";
w1363 = ptr + 2;
w1364 = stack[w1363];

w1365 = ptr + 3;

w1366 = w1365 + 0;
stack[w1366] = w1364;

ptr = ptr + 3;
java_Nodo_getContenido();
ptr = ptr - 3;

//retorno
w1373 = ptr + 3;

w1374 = w1373 + 1;
w1375 = stack[w1374];


//retorno
cout<<w1375;
cout<<endl;
retorno6:
    cout<< " ";
}

int main(){
int w0;
int w1;
int w2;
int w3;
int w4;
int w5;
int w6;
int w7;
int w8;
int w9;
int w10;
int w11;
int w12;
int w13;

w0 = ptr + 0;
stack[w0] = 12;

w1 = ptr + 1;
stack[w1] = 6;

w2 = ptr + 2;
stack[w2] = 9;

w3 = ptr + 3;
stack[w3] = 88;

w4 = ptr + 5;

ptr = ptr + 5;
java_sumar_sumar();
ptr = ptr - 5;
w5 = ptr + 5;

w6 = w5 + 0;
w7 = stack[w6];

w8 = ptr + 4;
stack[w8] = w7;

w9 = ptr + 4;
w10 = stack[w9];

w11 = ptr + 5;

w12 = w11 + 0;
stack[w12] = w10;

w13 = ptr + 5;

ptr = ptr + 5;
java_sumar_iniciar();
ptr = ptr - 5;

}
//________________

//n!!!!!!!!!!!!!!!!!!!! !!!!

