package chapter7_OO._3_jukebox

import scala.collection.mutable.ListBuffer

class PlayList(var songs: ListBuffer[Song] = ListBuffer()) {
  def addSong(song: Song): Unit = songs += song
  def removeSong(song: Song): Unit = songs -= song
  def getSongFromTitle(title: String): Song = {
    for (song <- songs)
      if (song.title == title)
        return song
    songs.head
  }
}
