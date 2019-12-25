package chapter7_OO._3_jukebox

class JukeBox(val playList: PlayList) {
  var credit = 0

  def addCredit(amount: Int): Unit = credit += amount

  def play: Option[Song] = {
    if (credit > 0) {
      credit -= 10
      return Some(playList.songs.head)
    }
    None
  }

  def playSong(title: String): Option[Song] = {
    if (credit > 0) {
      credit -= 10
      return Some(playList.getSongFromTitle(title))
    }
    None
  }
}
