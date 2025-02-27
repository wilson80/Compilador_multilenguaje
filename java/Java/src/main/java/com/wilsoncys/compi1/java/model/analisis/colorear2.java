// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: colorear.jflex

package com.wilsoncys.compi1.java.model.analisis;


// importaciones
import java_cup.runtime.Symbol;
import java.util.LinkedList;
import com.wilsoncys.compi1.java.model.excepciones.Errores;
import com.wilsoncys.compi1.java.vistas.colorInfo;
import com.wilsoncys.compi1.java.vistas.TipoT; 



@SuppressWarnings("fallthrough")
public class colorear2 {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int JAVA = 2;
  public static final int PROGRAMA = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1,  1,  2, 2
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\3\2\1\22\0\1\1\1\4"+
    "\1\5\1\6\1\0\1\7\1\10\1\11\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\1\21\12\22\1\23"+
    "\1\16\1\24\1\25\1\26\2\0\1\27\1\30\1\31"+
    "\3\32\1\33\2\32\1\34\1\32\1\35\1\36\1\32"+
    "\1\37\1\40\1\32\1\41\1\42\2\32\1\43\4\32"+
    "\1\44\1\45\1\44\1\46\1\47\1\0\1\50\1\51"+
    "\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\32"+
    "\1\61\1\62\1\63\1\64\1\65\1\66\1\32\1\67"+
    "\1\70\1\71\1\72\1\73\1\74\1\75\1\76\1\32"+
    "\1\77\1\100\1\101\7\0\1\3\u01a2\0\2\3\326\0"+
    "\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\1\2\2\1\2\3\1\4\1\5\2\4"+
    "\22\5\1\3\1\1\1\4\2\1\3\4\15\5\3\1"+
    "\2\4\12\5\2\0\1\5\3\0\11\5\1\6\11\5"+
    "\1\0\1\2\1\0\1\5\5\0\1\3\16\5\3\0"+
    "\11\5\2\0\1\5\1\0\7\5\1\4\11\5\1\0"+
    "\1\5\1\0\5\5\1\6\5\5\3\0\10\5\2\0"+
    "\14\5\1\0\10\5\3\0\1\7\5\5\2\0\6\5"+
    "\1\0\3\5\1\6\3\5\3\0\1\5\1\10\1\0"+
    "\2\5\1\0\2\5\4\0\1\5\1\0\1\5\4\0"+
    "\1\11\1\0\1\7\2\0\1\12";

  private static int [] zzUnpackAction() {
    int [] result = new int[250];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\102\0\204\0\306\0\u0108\0\u014a\0\u018c\0\u01ce"+
    "\0\306\0\306\0\u0210\0\u0252\0\u0294\0\u02d6\0\u0318\0\u035a"+
    "\0\u039c\0\u03de\0\u0420\0\u0462\0\u04a4\0\u04e6\0\u0528\0\u056a"+
    "\0\u05ac\0\u05ee\0\u0630\0\u0672\0\u06b4\0\u06f6\0\u0738\0\u077a"+
    "\0\u07bc\0\u07fe\0\u0840\0\u0882\0\u08c4\0\u0906\0\u0948\0\u098a"+
    "\0\u09cc\0\u0a0e\0\u0a50\0\u0a92\0\u0ad4\0\u0b16\0\u0b58\0\u0b9a"+
    "\0\u0bdc\0\u0c1e\0\u0c60\0\u0ca2\0\u0ce4\0\u0d26\0\u0d68\0\u0daa"+
    "\0\u0840\0\u0dec\0\u0e2e\0\u0e70\0\u0eb2\0\u0ef4\0\u0f36\0\u0f78"+
    "\0\u0fba\0\u0ffc\0\u103e\0\u1080\0\u10c2\0\u1104\0\u1146\0\u1188"+
    "\0\u11ca\0\u120c\0\u124e\0\u1290\0\u12d2\0\u1314\0\u1356\0\u1398"+
    "\0\u13da\0\u141c\0\u02d6\0\u145e\0\u14a0\0\u14e2\0\u1524\0\u1566"+
    "\0\u15a8\0\u15ea\0\u162c\0\u166e\0\u077a\0\u077a\0\u07bc\0\306"+
    "\0\u16b0\0\u16f2\0\u1734\0\u1776\0\u17b8\0\u17fa\0\u183c\0\u187e"+
    "\0\u18c0\0\u1902\0\u1944\0\u1986\0\u19c8\0\u1a0a\0\u1a4c\0\u1a8e"+
    "\0\u1ad0\0\u1b12\0\u1b54\0\u1b96\0\u1bd8\0\u1c1a\0\u1c5c\0\u1c9e"+
    "\0\u1ce0\0\u1d22\0\u1d64\0\u1da6\0\u1de8\0\u1e2a\0\u1e6c\0\u1eae"+
    "\0\u1ef0\0\u1f32\0\u1f74\0\u1fb6\0\u11ca\0\u1ff8\0\u203a\0\u207c"+
    "\0\u20be\0\u2100\0\u2142\0\u02d6\0\u2184\0\u21c6\0\u2208\0\u224a"+
    "\0\u228c\0\u22ce\0\u2310\0\u2352\0\u2394\0\u23d6\0\u1734\0\u2418"+
    "\0\u245a\0\u249c\0\u24de\0\u2520\0\u2562\0\u25a4\0\u25e6\0\u2628"+
    "\0\u266a\0\u26ac\0\u26ee\0\u2730\0\u2772\0\u27b4\0\u27f6\0\u2838"+
    "\0\u287a\0\u28bc\0\u28fe\0\u2940\0\u2982\0\u29c4\0\u2a06\0\u2a48"+
    "\0\u10c2\0\u2a8a\0\u2acc\0\u2b0e\0\u2b50\0\u2b92\0\u2bd4\0\u2c16"+
    "\0\u2c58\0\u2c9a\0\u2cdc\0\u2d1e\0\u2d60\0\u2da2\0\u2de4\0\u2e26"+
    "\0\u2e68\0\u2eaa\0\u2eec\0\u2f2e\0\u2f70\0\u2fb2\0\u2ff4\0\u3036"+
    "\0\u02d6\0\u3078\0\u30ba\0\u30fc\0\u313e\0\u3180\0\u31c2\0\u3204"+
    "\0\u3246\0\u3288\0\u32ca\0\u330c\0\u334e\0\u3390\0\u33d2\0\u3414"+
    "\0\u3456\0\u3498\0\u2cdc\0\u34da\0\u351c\0\u355e\0\u35a0\0\u35e2"+
    "\0\u3624\0\u3666\0\306\0\u36a8\0\u36ea\0\u372c\0\u376e\0\u37b0"+
    "\0\u37f2\0\u3834\0\u3876\0\u38b8\0\u38fa\0\u393c\0\u397e\0\u39c0"+
    "\0\u3a02\0\u3a44\0\u3a86\0\u3ac8\0\306\0\u3b0a\0\306\0\u3b4c"+
    "\0\u3b8e\0\306";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[250];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\2\5\1\0\3\4\1\6\1\4\1\7\1\10"+
    "\1\11\5\12\1\4\1\13\1\14\1\15\1\12\1\14"+
    "\13\16\1\17\1\16\1\11\3\4\1\20\1\21\1\22"+
    "\1\23\1\24\1\25\2\16\1\26\2\16\1\27\1\30"+
    "\1\31\1\32\1\33\1\16\1\34\1\35\1\36\1\37"+
    "\2\16\1\40\1\4\1\11\1\4\2\5\1\0\1\14"+
    "\1\41\1\4\1\42\1\43\1\44\3\12\1\45\1\12"+
    "\1\46\1\12\1\47\1\13\1\12\3\14\1\16\1\50"+
    "\11\16\1\17\1\16\1\12\1\4\1\12\1\4\1\16"+
    "\1\51\1\52\1\53\1\54\1\55\2\16\1\56\3\16"+
    "\1\57\1\16\1\60\1\61\1\62\1\63\1\16\1\64"+
    "\1\37\2\16\1\12\1\65\1\12\1\4\2\5\1\0"+
    "\1\14\1\66\1\67\1\70\1\71\1\44\3\12\1\45"+
    "\1\12\1\46\1\12\1\47\1\13\1\12\3\14\1\16"+
    "\1\50\3\16\1\72\3\16\1\73\3\16\1\12\1\4"+
    "\1\12\1\4\2\16\1\74\1\53\1\75\1\76\1\77"+
    "\1\16\1\100\2\16\1\101\2\16\1\102\1\16\1\103"+
    "\2\16\1\64\1\37\2\16\1\12\1\65\1\12\103\0"+
    "\2\5\106\0\1\104\72\0\11\105\1\106\33\105\1\107"+
    "\34\105\14\0\1\110\105\0\1\111\1\0\1\13\104\0"+
    "\1\12\101\0\2\12\75\0\1\16\4\0\15\16\3\0"+
    "\30\16\25\0\1\16\4\0\15\16\3\0\22\16\1\112"+
    "\5\16\25\0\1\16\4\0\15\16\3\0\15\16\1\113"+
    "\2\16\1\114\7\16\25\0\1\16\4\0\15\16\3\0"+
    "\5\16\1\115\10\16\1\116\1\16\1\117\7\16\25\0"+
    "\1\16\4\0\15\16\3\0\1\16\1\120\6\16\1\36"+
    "\5\16\1\121\11\16\25\0\1\16\4\0\15\16\3\0"+
    "\11\16\1\122\4\16\1\123\11\16\25\0\1\16\4\0"+
    "\15\16\3\0\13\16\1\120\1\16\1\113\12\16\25\0"+
    "\1\16\4\0\15\16\3\0\16\16\1\124\4\16\1\125"+
    "\4\16\25\0\1\16\4\0\15\16\3\0\6\16\1\123"+
    "\6\16\1\126\12\16\25\0\1\16\4\0\15\16\3\0"+
    "\16\16\1\113\11\16\25\0\1\16\4\0\15\16\3\0"+
    "\16\16\1\127\11\16\25\0\1\16\4\0\15\16\3\0"+
    "\6\16\1\123\11\16\1\123\7\16\25\0\1\16\4\0"+
    "\15\16\3\0\20\16\1\130\7\16\25\0\1\16\4\0"+
    "\15\16\3\0\5\16\1\131\22\16\25\0\1\16\4\0"+
    "\15\16\3\0\10\16\1\132\5\16\1\123\11\16\25\0"+
    "\1\16\4\0\15\16\3\0\15\16\1\133\12\16\25\0"+
    "\1\16\4\0\15\16\3\0\1\16\1\124\26\16\25\0"+
    "\1\16\4\0\15\16\3\0\10\16\1\134\17\16\3\0"+
    "\2\135\1\0\76\135\1\136\5\137\1\140\37\137\1\141"+
    "\34\137\7\0\1\142\102\0\1\12\71\0\11\143\1\0"+
    "\33\143\1\144\34\143\15\0\1\12\103\0\1\12\76\0"+
    "\1\145\4\0\1\146\102\0\1\16\4\0\15\16\3\0"+
    "\20\16\1\117\7\16\25\0\1\16\4\0\15\16\3\0"+
    "\16\16\1\116\11\16\25\0\1\16\4\0\15\16\3\0"+
    "\1\16\1\120\6\16\1\147\2\16\1\150\2\16\1\121"+
    "\11\16\25\0\1\16\4\0\15\16\3\0\5\16\1\151"+
    "\10\16\1\123\11\16\25\0\1\16\4\0\15\16\3\0"+
    "\13\16\1\120\12\16\1\152\1\16\25\0\1\16\4\0"+
    "\15\16\3\0\1\16\1\75\11\16\1\153\2\16\1\124"+
    "\11\16\25\0\1\16\4\0\15\16\3\0\6\16\1\123"+
    "\6\16\1\154\12\16\25\0\1\16\4\0\15\16\3\0"+
    "\5\16\1\155\22\16\25\0\1\16\4\0\15\16\3\0"+
    "\20\16\1\156\2\16\1\157\4\16\25\0\1\16\4\0"+
    "\15\16\3\0\5\16\1\160\22\16\25\0\1\16\4\0"+
    "\15\16\3\0\25\16\1\161\2\16\25\0\1\16\4\0"+
    "\15\16\3\0\10\16\1\162\7\16\1\163\7\16\25\0"+
    "\1\16\4\0\15\16\3\0\16\16\1\164\11\16\103\0"+
    "\1\12\1\0\5\137\1\140\26\137\1\165\3\137\1\166"+
    "\4\137\1\141\34\137\60\0\1\167\73\0\2\12\1\0"+
    "\1\12\12\0\1\12\33\0\1\16\4\0\1\170\14\16"+
    "\3\0\30\16\25\0\1\16\4\0\1\171\14\16\3\0"+
    "\30\16\25\0\1\16\4\0\15\16\3\0\1\16\1\120"+
    "\6\16\1\36\2\16\1\172\2\16\1\173\11\16\25\0"+
    "\1\16\4\0\15\16\3\0\13\16\1\120\14\16\25\0"+
    "\1\16\4\0\15\16\3\0\13\16\1\174\2\16\1\124"+
    "\11\16\25\0\1\16\4\0\15\16\3\0\5\16\1\175"+
    "\22\16\25\0\1\16\4\0\15\16\3\0\6\16\1\123"+
    "\6\16\1\127\12\16\25\0\1\16\4\0\15\16\3\0"+
    "\1\16\1\176\26\16\25\0\1\16\4\0\15\16\3\0"+
    "\20\16\1\177\7\16\25\0\1\16\4\0\15\16\3\0"+
    "\3\16\1\200\16\16\1\112\2\16\1\161\2\16\37\0"+
    "\1\201\3\0\1\202\41\0\11\105\1\106\70\105\11\0"+
    "\1\105\70\0\11\105\1\203\70\105\14\110\1\204\65\110"+
    "\22\0\1\205\101\0\1\16\4\0\15\16\3\0\20\16"+
    "\1\206\7\16\25\0\1\16\4\0\15\16\3\0\4\16"+
    "\1\123\23\16\25\0\1\16\4\0\15\16\3\0\20\16"+
    "\1\207\7\16\25\0\1\16\4\0\15\16\3\0\7\16"+
    "\1\176\20\16\25\0\1\16\4\0\15\16\3\0\16\16"+
    "\1\210\11\16\25\0\1\16\4\0\15\16\3\0\5\16"+
    "\1\211\22\16\25\0\1\16\4\0\15\16\3\0\21\16"+
    "\1\212\6\16\25\0\1\16\4\0\15\16\3\0\15\16"+
    "\1\213\12\16\25\0\1\16\4\0\15\16\3\0\24\16"+
    "\1\214\3\16\25\0\1\16\4\0\15\16\3\0\20\16"+
    "\1\123\7\16\25\0\1\16\4\0\15\16\3\0\15\16"+
    "\1\215\12\16\25\0\1\16\4\0\15\16\3\0\22\16"+
    "\1\216\5\16\25\0\1\16\4\0\15\16\3\0\22\16"+
    "\1\123\5\16\25\0\1\16\4\0\15\16\3\0\11\16"+
    "\1\217\4\16\1\220\11\16\25\0\1\16\4\0\15\16"+
    "\3\0\1\16\1\221\15\16\1\222\10\16\25\0\1\16"+
    "\4\0\15\16\3\0\5\16\1\223\22\16\25\0\1\16"+
    "\4\0\15\16\3\0\22\16\1\224\5\16\25\0\1\16"+
    "\4\0\15\16\3\0\11\16\1\225\16\16\10\0\1\137"+
    "\3\0\1\137\33\0\1\137\16\0\1\137\4\0\1\137"+
    "\50\0\1\226\52\0\1\140\101\0\1\227\33\0\1\143"+
    "\16\0\1\143\2\0\1\143\1\0\1\143\10\0\14\145"+
    "\1\230\65\145\2\146\1\0\77\146\22\0\1\16\4\0"+
    "\15\16\3\0\1\16\1\231\26\16\25\0\1\16\4\0"+
    "\15\16\3\0\1\16\1\232\26\16\25\0\1\16\4\0"+
    "\15\16\3\0\6\16\1\233\21\16\25\0\1\16\4\0"+
    "\15\16\3\0\22\16\1\234\5\16\25\0\1\16\4\0"+
    "\15\16\3\0\16\16\1\235\11\16\25\0\1\16\4\0"+
    "\15\16\3\0\22\16\1\236\5\16\25\0\1\16\4\0"+
    "\15\16\3\0\25\16\1\123\2\16\25\0\1\16\4\0"+
    "\15\16\3\0\11\16\1\237\4\16\1\240\11\16\25\0"+
    "\1\16\4\0\15\16\3\0\2\16\1\241\25\16\25\0"+
    "\1\16\4\0\15\16\3\0\22\16\1\242\5\16\25\0"+
    "\1\16\4\0\15\16\3\0\11\16\1\175\16\16\25\0"+
    "\1\16\4\0\15\16\3\0\11\16\1\243\16\16\25\0"+
    "\1\16\4\0\15\16\3\0\23\16\1\212\4\16\25\0"+
    "\1\16\4\0\15\16\3\0\11\16\1\113\16\16\3\0"+
    "\5\137\1\140\21\137\1\244\15\137\1\141\41\137\1\140"+
    "\21\137\1\245\15\137\1\141\34\137\64\0\1\246\37\0"+
    "\1\16\4\0\14\16\1\247\3\0\30\16\25\0\1\16"+
    "\4\0\13\16\1\250\1\16\3\0\30\16\25\0\1\16"+
    "\4\0\15\16\3\0\20\16\1\251\7\16\25\0\1\16"+
    "\4\0\15\16\3\0\15\16\1\252\12\16\25\0\1\16"+
    "\4\0\15\16\3\0\16\16\1\253\11\16\25\0\1\16"+
    "\4\0\15\16\3\0\22\16\1\254\5\16\25\0\1\16"+
    "\4\0\15\16\3\0\11\16\1\223\16\16\25\0\1\16"+
    "\4\0\15\16\3\0\11\16\1\255\16\16\25\0\1\16"+
    "\4\0\15\16\3\0\1\16\1\256\26\16\32\0\1\257"+
    "\101\0\1\260\63\0\1\261\70\0\13\110\1\11\66\110"+
    "\22\0\1\16\4\0\15\16\3\0\11\16\1\262\16\16"+
    "\25\0\1\16\4\0\15\16\3\0\1\16\1\263\26\16"+
    "\25\0\1\16\4\0\15\16\3\0\13\16\1\264\14\16"+
    "\25\0\1\16\4\0\15\16\3\0\1\16\1\265\26\16"+
    "\25\0\1\16\4\0\15\16\3\0\5\16\1\123\22\16"+
    "\25\0\1\16\4\0\15\16\3\0\22\16\1\266\5\16"+
    "\25\0\1\16\4\0\15\16\3\0\3\16\1\267\24\16"+
    "\25\0\1\16\4\0\15\16\3\0\5\16\1\270\22\16"+
    "\25\0\1\16\4\0\15\16\3\0\15\16\1\271\12\16"+
    "\25\0\1\16\4\0\15\16\3\0\3\16\1\272\24\16"+
    "\25\0\1\16\4\0\15\16\3\0\4\16\1\273\6\16"+
    "\1\123\14\16\25\0\1\16\4\0\15\16\3\0\5\16"+
    "\1\253\22\16\25\0\1\16\4\0\15\16\3\0\15\16"+
    "\1\123\12\16\25\0\1\16\4\0\15\16\3\0\11\16"+
    "\1\274\16\16\25\0\1\16\4\0\15\16\3\0\13\16"+
    "\1\212\14\16\44\0\1\275\40\0\14\145\1\230\4\145"+
    "\1\11\60\145\22\0\1\16\4\0\15\16\3\0\20\16"+
    "\1\236\7\16\25\0\1\16\4\0\15\16\3\0\21\16"+
    "\1\243\6\16\25\0\1\16\4\0\15\16\3\0\1\16"+
    "\1\276\26\16\25\0\1\16\4\0\15\16\3\0\5\16"+
    "\1\277\22\16\25\0\1\16\4\0\15\16\3\0\1\16"+
    "\1\154\26\16\25\0\1\16\4\0\15\16\3\0\11\16"+
    "\1\300\16\16\25\0\1\16\4\0\15\16\3\0\15\16"+
    "\1\301\6\16\1\302\3\16\25\0\1\16\4\0\15\16"+
    "\3\0\22\16\1\303\5\16\25\0\1\16\4\0\15\16"+
    "\3\0\13\16\1\304\14\16\25\0\1\16\4\0\15\16"+
    "\3\0\23\16\1\305\4\16\25\0\1\16\4\0\15\16"+
    "\3\0\21\16\1\123\6\16\3\0\5\137\1\140\35\137"+
    "\1\306\1\137\1\141\41\137\1\140\34\137\1\307\2\137"+
    "\1\141\34\137\52\0\1\310\51\0\1\16\4\0\1\311"+
    "\14\16\3\0\30\16\25\0\1\16\4\0\2\16\1\312"+
    "\12\16\3\0\30\16\25\0\1\16\4\0\15\16\3\0"+
    "\21\16\1\313\6\16\25\0\1\16\4\0\15\16\3\0"+
    "\21\16\1\127\1\266\5\16\25\0\1\16\4\0\15\16"+
    "\3\0\1\16\1\127\26\16\25\0\1\16\4\0\15\16"+
    "\3\0\3\16\1\314\24\16\25\0\1\16\4\0\15\16"+
    "\3\0\15\16\1\315\12\16\25\0\1\16\4\0\15\16"+
    "\3\0\15\16\1\316\12\16\46\0\1\317\100\0\1\320"+
    "\61\0\1\16\4\0\15\16\3\0\15\16\1\321\12\16"+
    "\25\0\1\16\4\0\15\16\3\0\27\16\1\123\25\0"+
    "\1\16\4\0\15\16\3\0\5\16\1\322\22\16\25\0"+
    "\1\16\4\0\15\16\3\0\12\16\1\123\15\16\25\0"+
    "\1\16\4\0\15\16\3\0\11\16\1\323\16\16\25\0"+
    "\1\16\4\0\15\16\3\0\22\16\1\324\5\16\25\0"+
    "\1\16\4\0\15\16\3\0\7\16\1\325\20\16\25\0"+
    "\1\16\4\0\15\16\3\0\22\16\1\273\5\16\25\0"+
    "\1\16\4\0\15\16\3\0\5\16\1\326\22\16\25\0"+
    "\1\16\4\0\15\16\3\0\13\16\1\223\14\16\25\0"+
    "\1\16\4\0\15\16\3\0\13\16\1\123\14\16\42\0"+
    "\1\327\64\0\1\16\4\0\15\16\3\0\23\16\1\330"+
    "\4\16\25\0\1\16\4\0\15\16\3\0\15\16\1\331"+
    "\12\16\25\0\1\16\4\0\15\16\3\0\15\16\1\332"+
    "\12\16\25\0\1\16\4\0\15\16\3\0\22\16\1\333"+
    "\5\16\25\0\1\16\4\0\15\16\3\0\1\16\1\334"+
    "\26\16\25\0\1\16\4\0\15\16\3\0\5\16\1\335"+
    "\22\16\25\0\1\16\4\0\15\16\3\0\11\16\1\336"+
    "\16\16\25\0\1\16\4\0\15\16\3\0\20\16\1\223"+
    "\7\16\3\0\5\137\1\140\21\137\1\337\15\137\1\141"+
    "\41\137\1\140\23\137\1\340\13\137\1\141\34\137\62\0"+
    "\1\341\41\0\1\16\4\0\1\342\14\16\3\0\30\16"+
    "\25\0\1\16\4\0\15\16\3\0\3\16\1\124\24\16"+
    "\25\0\1\16\4\0\15\16\3\0\10\16\1\123\17\16"+
    "\25\0\1\16\4\0\15\16\3\0\22\16\1\316\5\16"+
    "\25\0\1\16\4\0\15\16\3\0\6\16\1\123\21\16"+
    "\32\0\1\343\103\0\1\344\72\0\1\16\4\0\15\16"+
    "\3\0\7\16\1\123\20\16\25\0\1\16\4\0\15\16"+
    "\3\0\1\16\1\223\26\16\25\0\1\16\4\0\15\16"+
    "\3\0\15\16\1\163\12\16\25\0\1\16\4\0\15\16"+
    "\3\0\11\16\1\345\16\16\25\0\1\16\4\0\15\16"+
    "\3\0\5\16\1\124\22\16\25\0\1\16\4\0\15\16"+
    "\3\0\4\16\1\346\23\16\36\0\1\347\70\0\1\16"+
    "\4\0\15\16\3\0\13\16\1\127\14\16\25\0\1\16"+
    "\4\0\15\16\3\0\4\16\1\243\23\16\25\0\1\16"+
    "\4\0\15\16\3\0\17\16\1\350\10\16\25\0\1\16"+
    "\4\0\15\16\3\0\22\16\1\212\5\16\25\0\1\16"+
    "\4\0\15\16\3\0\3\16\1\351\24\16\25\0\1\16"+
    "\4\0\15\16\3\0\3\16\1\123\24\16\3\0\5\137"+
    "\1\140\12\137\1\352\24\137\1\141\41\137\1\140\21\137"+
    "\1\353\15\137\1\141\34\137\72\0\1\354\31\0\1\16"+
    "\4\0\6\16\1\311\6\16\3\0\30\16\32\0\1\355"+
    "\74\0\1\16\4\0\15\16\3\0\16\16\1\223\11\16"+
    "\25\0\1\16\4\0\15\16\3\0\23\16\1\356\4\16"+
    "\44\0\1\357\62\0\1\16\4\0\15\16\3\0\23\16"+
    "\1\127\4\16\25\0\1\16\4\0\15\16\3\0\22\16"+
    "\1\360\5\16\3\0\5\137\1\140\6\137\1\361\12\137"+
    "\15\362\1\137\1\141\2\137\27\362\10\137\1\140\27\137"+
    "\1\363\7\137\1\141\34\137\53\0\1\364\63\0\1\365"+
    "\66\0\1\16\4\0\15\16\3\0\20\16\1\212\7\16"+
    "\32\0\1\366\74\0\1\16\4\0\15\16\3\0\5\16"+
    "\1\113\22\16\3\0\5\137\1\367\37\137\1\141\41\137"+
    "\1\367\14\137\1\362\4\137\15\362\1\137\1\141\1\137"+
    "\30\362\10\137\1\367\12\137\1\370\24\137\1\141\34\137"+
    "\54\0\1\367\63\0\1\371\43\0\5\137\1\140\21\137"+
    "\15\362\1\137\1\141\2\137\27\362\3\137\27\0\1\372"+
    "\52\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[15312];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\11\4\1\2\11\71\1\2\0\1\1\3\0"+
    "\23\1\1\0\1\1\1\0\1\11\5\0\17\1\3\0"+
    "\11\1\2\0\1\1\1\0\21\1\1\0\1\1\1\0"+
    "\13\1\3\0\10\1\2\0\14\1\1\0\10\1\3\0"+
    "\6\1\2\0\6\1\1\0\7\1\3\0\1\1\1\11"+
    "\1\0\2\1\1\0\2\1\4\0\1\1\1\0\1\1"+
    "\4\0\1\11\1\0\1\11\2\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[250];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  @SuppressWarnings("unused")
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  @SuppressWarnings("unused")
  private boolean zzEOFDone;

  /* user code: */
    //  private Reader yyreader;

    // public colorear2(String input) {
    //     this.yyreader = new StringReader(input); 
    //         }

                    //linea que provocaba el sobre elvado uso del procesador 
    // public LinkedList<Errores> listaErrores = new LinkedList<>();   
    
 
        StringBuilder string;
    private colorInfo colorr(TipoT type){
        return new  colorInfo(type, yychar, yylength());
    }
    private colorInfo colorSTR(TipoT type){
        return new  colorInfo(type, yychar-string.toString().length()-1,  string.toString().length()+1); 
    }
 




  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public colorear2(java.io.Reader in) {
      string = new StringBuilder();
     
 
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public colorInfo yylex() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { { return colorr(TipoT.ERROR); }
            }
          // fall through
          case 11: break;
          case 2:
            { 
            }
          // fall through
          case 12: break;
          case 3:
            { return colorr(TipoT.COMMENT);
            }
          // fall through
          case 13: break;
          case 4:
            { return colorr(TipoT.SYMSS);
            }
          // fall through
          case 14: break;
          case 5:
            { return colorr(TipoT.VAL);
            }
          // fall through
          case 15: break;
          case 6:
            { return colorr(TipoT.RESERV);
            }
          // fall through
          case 16: break;
          case 7:
            { return colorr(TipoT.TODOO);
            }
          // fall through
          case 17: break;
          case 8:
            { yybegin(JAVA); return colorr(TipoT.SECTION);
            }
          // fall through
          case 18: break;
          case 9:
            { yybegin(YYINITIAL); return colorr(TipoT.SECTION);
            }
          // fall through
          case 19: break;
          case 10:
            { yybegin(PROGRAMA); return colorr(TipoT.SECTION);
            }
          // fall through
          case 20: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
