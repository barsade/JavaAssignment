//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        EfficientMap efficientMap = new EfficientMap();

        var a = efficientMap.getWarmest();
        var b = efficientMap.put("a", 100);
        var c = efficientMap.getWarmest();
        var d = efficientMap.put("a", 101);
        var e = efficientMap.put("a", 101);
        var f = efficientMap.get("a");
        var g = efficientMap.getWarmest();
        var h = efficientMap.remove("a");
        var i = efficientMap.remove("a");
        var j = efficientMap.getWarmest();
        var k = efficientMap.put("a", 100);
        var l = efficientMap.put("b", 200);
        var m = efficientMap.getWarmest();
        var n = efficientMap.put("c", 300);
        var o = efficientMap.getWarmest();
        var p = efficientMap.get("a");
        var q = efficientMap.getWarmest();
        var r = efficientMap.remove("a");
        var s = efficientMap.getWarmest();
        var t = efficientMap.put("b", 200);
        var u = efficientMap.getWarmest();
    }
}