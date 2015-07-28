package two

/**
 * Created by usezer on 28.07.2015.
 */
class ChecksumAccumulator {
  private var sum = 0;

  def add(b: Byte) {
    sum += b
  }


  def checksum(): Int = ~(sum & 0xFF) + 1


}
