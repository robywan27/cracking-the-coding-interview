package chapter7_OO._3_jukebox

object JukeBoxTester {
  def main(args: Array[String]): Unit = {
    val s1 = Song("Tasty", "4.30", "Cuba Libre")
    val s2 = Song("Frenzy", "1.12", "Cuba Libre")
    val s3 = Song("Nightmare", "25.00", "Ginger")
    val s4 = Song("Going Home", "3.35", "Ginger")
    val s5 = Song("Love", "8.20", "Rastafari")
    val s6 = Song("Epidermic", "10.30", "Rastafari")

    val playList = new PlayList()
    playList.addSong(s1)
    playList.addSong(s2)
    playList.addSong(s3)
    playList.addSong(s4)
    playList.addSong(s5)
    playList.addSong(s6)

    val jukeBox = new JukeBox(playList)
    jukeBox.addCredit(20)
    println(jukeBox.play.getOrElse("No credit available"))
    println(jukeBox.playSong("Nightmare").getOrElse("No credit available"))
    println(jukeBox.play.getOrElse("No credit available"))
  }
}
