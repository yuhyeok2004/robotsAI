public class NonAdmissibleHeuristic implements AStarHeuristic {
/**
*NonAdmissibleHeuristic == 2 * ClosestHeuristic
*/
//(call it on a reference that points to an instance of a class.)
//(Whichever class that is determines which method gets called)
//Interface interface = new ConcreteClass();
public float getCost(GridBasedMap map, Mover mover, int x, int y, int tx, int ty) {
//Manhattan Distance
dx = abs(tx x)
;
dy = abs(ty y)
;
result = 2*(dx+dy);
return result;
}
}
