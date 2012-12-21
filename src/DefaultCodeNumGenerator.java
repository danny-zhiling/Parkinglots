import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: 51ibm
 * Date: 12-12-16
 * Time: 下午2:47
 * To change this template use File | Settings | File Templates.
 */
public class DefaultCodeNumGenerator implements ICodeNumGenrator {

    private static Hashtable<String,Integer> NumCount = new Hashtable<String,Integer>();
    @Override
    public String GetCodeNum(Object Obj) {
        String Name = Obj.getClass().getName();
        if  (!NumCount.containsKey(Name))
        {
            NumCount.put(Name,0) ;
        }
        int result = NumCount.get(Name)+1;
        NumCount.put(Name,result)   ;
        return String.valueOf( result);
    }
}
