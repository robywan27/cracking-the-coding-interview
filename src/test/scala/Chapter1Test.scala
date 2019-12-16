import org.scalatest.FunSuite
import chapter1._1_UniqueCharacters
import chapter1._2_ReverseString
import chapter1._4_Anagrams
import chapter1._5_ReplaceSpaces
import chapter1._8_Rotation

class Chapter1Test extends FunSuite {
  test("_1_UniqueCharacters") {
    assert(_1_UniqueCharacters.hasAllUniqueCharacters("STRINGA") === true)
    assert(_1_UniqueCharacters.hasAllUniqueCharacters("CASA") === false)
    assert(_1_UniqueCharacters.hasAllUniqueCharacters("TRINCEA") === true)
    assert(_1_UniqueCharacters.hasAllUniqueCharacters("AMIGDALA") === false)

    assert(_1_UniqueCharacters.hasAllUniqueCharacters_2("STRINGA") === true)
    assert(_1_UniqueCharacters.hasAllUniqueCharacters_2("CASA") === false)
    assert(_1_UniqueCharacters.hasAllUniqueCharacters_2("TRINCEA") === true)
    assert(_1_UniqueCharacters.hasAllUniqueCharacters_2("AMIGDALA") === false)

    assert(_1_UniqueCharacters.hasAllUniqueCharacters_3("STRINGA") === true)
    assert(_1_UniqueCharacters.hasAllUniqueCharacters_3("CASA") === false)
    assert(_1_UniqueCharacters.hasAllUniqueCharacters_3("TRINCEA") === true)
    assert(_1_UniqueCharacters.hasAllUniqueCharacters_3("AMIGDALA") === false)

    assert(_1_UniqueCharacters.hasAllUniqueCharacters_4("STRINGA") === true)
    assert(_1_UniqueCharacters.hasAllUniqueCharacters_4("CASA") === false)
    assert(_1_UniqueCharacters.hasAllUniqueCharacters_4("TRINCEA") === true)
    assert(_1_UniqueCharacters.hasAllUniqueCharacters_4("AMIGDALA") === false)
  }


  test("_2_ReverseString") {
    assert(_2_ReverseString.reverseString("abcd\u0000") === "dcba\u0000")
    assert(_2_ReverseString.reverseString("ABABBBA\u0000") === "ABBBABA\u0000")
    assert(_2_ReverseString.reverseString("rotator\u0000") === "rotator\u0000")
  }


  test("_4_Anagrams") {
    assert(_4_Anagrams.anagrams("restful", "fluster") === true)
    assert(_4_Anagrams.anagrams("placebo", "obecalp") === true)
    assert(_4_Anagrams.anagrams("placebo", "obacalp") === false)
    // notice the extra space after tom in the first string below; the algorithm checks
    // each and every character for a match, including space and special characters
    assert(_4_Anagrams.anagrams("tom  marvolo riddle", "i am lord voldemort") === true)
    assert(_4_Anagrams.anagrams("madam curie", "radium came") === true)

    assert(_4_Anagrams.anagrams_2("restful", "fluster") === true)
    assert(_4_Anagrams.anagrams_2("placebo", "obecalp") === true)
    assert(_4_Anagrams.anagrams_2("placebo", "obacalp") === false)
    assert(_4_Anagrams.anagrams_2("tom  marvolo riddle", "i am lord voldemort") === true)
    assert(_4_Anagrams.anagrams_2("madam curie", "radium came") === true)

    assert(_4_Anagrams.anagrams_3("restful", "fluster") === true)
    assert(_4_Anagrams.anagrams_3("placebo", "obecalp") === true)
    assert(_4_Anagrams.anagrams_3("placebo", "obacalp") === false)
    assert(_4_Anagrams.anagrams_3("tom  marvolo riddle", "i am lord voldemort") === true)
    assert(_4_Anagrams.anagrams_3("madam curie", "radium came") === true)
  }


  test("_5_ReplaceSpaces") {
    assert(_5_ReplaceSpaces.replaceSpaces("This is a string with many spaces") === "This%20is%20a%20string%20with%20many%20spaces")
    assert(_5_ReplaceSpaces.replaceSpaces("This string   has  multiple contiguous    spaces") === "This%20string%20%20%20has%20%20multiple%20contiguous%20%20%20%20spaces")

    assert(_5_ReplaceSpaces.replaceSpaces_2("This is a string with many spaces") === "This%20is%20a%20string%20with%20many%20spaces")
    assert(_5_ReplaceSpaces.replaceSpaces_2("This string   has  multiple contiguous    spaces") === "This%20string%20%20%20has%20%20multiple%20contiguous%20%20%20%20spaces")
  }


  test("_8_Rotation") {
    assert(_8_Rotation.isSubstring("abracadabra", "cada") === true)
    assert(_8_Rotation.isSubstring("abracadabra", "cade") === false)

    assert(_8_Rotation.isRotation("waterbottle", "erbottlewat") === true)
    assert(_8_Rotation.isRotation("engineering", "erbottlewat") === false)
    assert(_8_Rotation.isRotation("waterbottle", "erbotletwat") === false)
    assert(_8_Rotation.isRotation("apple", "pleap") === true)
    assert(_8_Rotation.isRotation("apple", "ppale") === false)
    assert(_8_Rotation.isRotation("catarifrangente", "rifrangentecata") === true)
    assert(_8_Rotation.isRotation("catarifrangente", "riflangentecata") === false)
    assert(_8_Rotation.isRotation("catarifrangente", "rifrangentecasa") === false)

    assert(_8_Rotation.isRotation_2("waterbottle", "erbottlewat") === true)
    assert(_8_Rotation.isRotation_2("engineering", "erbottlewat") === false)
    assert(_8_Rotation.isRotation_2("waterbottle", "erbotletwat") === false)
    assert(_8_Rotation.isRotation_2("apple", "pleap") === true)
    assert(_8_Rotation.isRotation_2("apple", "ppale") === false)
    assert(_8_Rotation.isRotation_2("catarifrangente", "rifrangentecata") === true)
    assert(_8_Rotation.isRotation_2("catarifrangente", "riflangentecata") === false)
    assert(_8_Rotation.isRotation_2("catarifrangente", "rifrangentecasa") === false)
  }
}
