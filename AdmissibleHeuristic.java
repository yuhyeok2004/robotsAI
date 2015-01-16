public class AdmissibleHeuristic implements AStarHeuristic {
  /**
  * @see AStarHeuristic#getCost(GridBasedMap, Mover, int, int, int, int)
  */
  public float getCost(GridBasedMap map, Mover mover, int x, int y, int tx, int ty) {
    //Manhattan Distance
    dx = abs(tx x);
    dy = abs(ty y);
    result = dx+dy;
    return result;
  }
}
