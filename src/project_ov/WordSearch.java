/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_ov;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author OV
 */
public class WordSearch extends Tools
  {

    private static String HS_name = "OV";
    private static long high_score;
    private long userScore;
    private int defaultCounter;
    private int scoreCounter = 0;
    private int remainCounter;
    private ArrayList<String> userAnswers = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private final String[] level =
    {
        "    ╦  ╔═╗╦  ╦╔═╗╦      ╔╗\n"
        + "    ║  ║╣ ╚╗╔╝║╣ ║       ║\n"
        + "    ╩═╝╚═╝ ╚╝ ╚═╝╩═╝    ═╩═\n\n"
        + "╔═════════════════════════════╗\n"
        + "║ A E S T L D P I G I R B O E ║\n"
        + "║ C N D Y S R O O O L S D G E ║\n"
        + "║ T T R R E I G P L R R I T X ║\n"
        + "║ A E O L I V K N O O Y L A E ║\n"
        + "║ F R W L B I S G I K E I L R ║\n"
        + "║ E T S A B N D N S D E I K C ║\n"
        + "║ G A S B O G R I G A I R I I ║\n"
        + "║ E I O T H D A Y O I P R N S ║\n"
        + "║ A N R O R T C A L T N E G E ║\n"
        + "║ T I C O D R I L F O I T T E ║\n"
        + "║ I N D F L P I P G Y O T K S ║\n"
        + "║ N G O I W A L K I N G S O T ║\n"
        + "║ G P O X L K R A P L W T T T ║\n"
        + "║ N K G N I H C T A W D R I B ║\n"
        + "║ A E S T L D P I G I R B O E ║\n"
        + "║ C N D Y S R O O O L S D G E ║\n"
        + "╚═════════════════════════════╝\n\n",
        "      ╦  ╔═╗╦  ╦╔═╗╦      ╔═╗\n"
        + "      ║  ║╣ ╚╗╔╝║╣ ║      ╔═╝ \n"
        + "      ╩═╝╚═╝ ╚╝ ╚═╝╩═╝    ╚═╝\n\n"
        + "╔═══════════════════════════════════╗\n"
        + "║ P S C X X G N I A B N K F A M X W ║\n"
        + "║ X Z X R H W J G L S A G D F J I C ║\n"
        + "║ L F G E N U S O H X L P V Y N S V ║\n"
        + "║ B I F I H T S O I D R O R D A E O ║\n"
        + "║ M L B I W S W X H H W A S I A L Q ║\n"
        + "║ A O F E O E F N O Q P Z I M L B R ║\n"
        + "║ R G J M R O L E V W D K V N Z R S ║\n"
        + "║ C N S S M W O S R W I B U D S A S ║\n"
        + "║ H I G J W Y W T B T I N Y V E M Q ║\n"
        + "║ T N C O H Z E I E Y C A Q W N S K ║\n"
        + "║ V E S T S J R N E R M V Y T J E B ║\n"
        + "║ S D T B U L S G T W Y S H I T L B ║\n"
        + "║ O R Z S G N I W O R G U L E B D Z ║\n"
        + "║ O A G R E E N L L A B E S A B D J ║\n"
        + "║ R G B Z L Y A C I K W Q L R Q U O ║\n"
        + "║ S Z X A F N M G D O X W P S O P O ║\n"
        + "║ W Z K R E N I H S N U S I I Y P B ║\n"
        + "╚═══════════════════════════════════╝\n\n",
        "        ╦  ╔═╗╦  ╦╔═╗╦      ╔═╗\n"
        + "        ║  ║╣ ╚╗╔╝║╣ ║       ═╣\n"
        + "        ╩═╝╚═╝ ╚╝ ╚═╝╩═╝    ╚═╝\n\n"
        + "╔═════════════════════════════════════════╗\n"
        + "║ M O J C P Y X E T D O F D O Z W O E S F ║\n"
        + "║ H C K E A S Y J D Z Q K X O C W D R V N ║\n"
        + "║ J N E U O 6 O P Z H Z B O V E F B D M E ║\n"
        + "║ F N Z Z S B H P V O L Y O X R A B J F W ║\n"
        + "║ A Q E L O Z C L D U H T H A E S H U T S ║\n"
        + "║ B X U I F J Q O I P K L P Z W U U W E G ║\n"
        + "║ S M M N T X O L p A E B O F A C Y J O K ║\n"
        + "║ J K X U Z R Z V X P H M H R N I E S F G ║\n"
        + "║ R I J P G B N A W F P Z K P Z W V K F G ║\n"
        + "║ S X B W I F E G P I B O S F G I N F Z L ║\n"
        + "║ I H M I J X O V K M O R E N U W V L B J ║\n"
        + "║ R T Q S T E F X T E B F V K Y J R A M D ║\n"
        + "║ N D M H P V D D Y Z D P L R M X V H X X ║\n"
        + "║ E G F Z E J D A M S Y N L Z M I Y U L H ║\n"
        + "║ H A D C M T Y I L W K N H F L K J D U W ║\n"
        + "║ T I B B D D R D J S Q P X J P W E N T N ║\n"
        + "║ G U G T L B B O V V S J J Q U R O A Q I ║\n"
        + "║ U Y Y Z O H Y N H M P M Q V T F P H W R ║\n"
        + "║ W X Y D S Y C N B R N F V C C V E O G C ║\n"
        + "║ Z Z V D X X S E N T X L W F Y O H X M S ║\n"
        + "╚═════════════════════════════════════════╝\n\n",
        "        ╦  ╔═╗╦  ╦╔═╗╦      ╦ ╦\n"
        + "        ║  ║╣ ╚╗╔╝║╣ ║      ╚═╣\n"
        + "        ╩═╝╚═╝ ╚╝ ╚═╝╩═╝      ╩\n\n"
        + "╔═════════════════════════════════════════╗\n"
        + "║ E U S A L A N T E N N A P G K V I E D N ║\n"
        + "║ T I T T N J U F P U G M G V C W H Z O J ║\n"
        + "║ S K S B M N R A O J B M F I I F G F Y J ║\n"
        + "║ J S R N E W Y R U S A C L X Y G L R R H ║\n"
        + "║ B W B R O A D C A S T I U C R I C Q J E ║\n"
        + "║ G N O I S I V E L E T S X K L E J E A V ║\n"
        + "║ D C I N O R T C E L E C A M R I D C L G ║\n"
        + "║ T Q W D F A C A F E R K B A I Y A L A I ║\n"
        + "║ E N E R G Y Y P C R Y O S O C O J D O N ║\n"
        + "║ G S E E A Y X S L I M E N N O R G J Y S ║\n"
        + "║ H Q L M M C J E O W N W E E W E O Q T L ║\n"
        + "║ S E K B P A I E M O D U L A T I O N O K ║\n"
        + "║ D U Z X L I P T H H Q C M B B S E F Y I ║\n"
        + "║ E Y C D I S U P S E V P T M R N I A Y M ║\n"
        + "║ S Z M O F Q D Q R A L A P T O P C L M V ║\n"
        + "║ S S X O I A C F E I L C A P A C I T O R ║\n"
        + "║ H O O K E D O H T A C P M X D R P Y M F ║\n"
        + "║ G S X H R I A U S I K O Z N C K C T R E ║\n"
        + "║ C F Y K F U D R A Q C V H X O G M X W F ║\n"
        + "║ P W I T L E N X M J X B Y A M F C V Z P ║\n"
        + "╚═════════════════════════════════════════╝\n\n",
        "           ╦  ╔═╗╦  ╦╔═╗╦      ╔═╗\n"
        + "           ║  ║╣ ╚╗╔╝║╣ ║      ╚═╗\n"
        + "           ╩═╝╚═╝ ╚╝ ╚═╝╩═╝    ╚═╝\n\n"
        + "╔═══════════════════════════════════════════════╗\n"
        + "║ C R A N B E R R I E S X C E K G W V B E R T A ║\n"
        + "║ R O L A S Y G Q J H Q U D P U D D I N G E T F ║\n"
        + "║ A L I H B R E A O Y U N M I P E C G Z W I Q B ║\n"
        + "║ N L F R D Z U B M T A P O A P P L E P I E C D ║\n"
        + "║ S S T U F F I N G N S O C H I U R T O A I G X ║\n"
        + "║ F T Y J B H D E D T H R R V L L F A T C A L M ║\n"
        + "║ H I P U K R B N C A D F V E G X T H A N K S O ║\n"
        + "║ M C L M H I N N O V E M B E R Z T H T O X G I ║\n"
        + "║ F A L L W Y L B R V Q K S V I P A H O G J H A ║\n"
        + "║ C S H I Y U J T N E O W I N M I D M E H U A L ║\n"
        + "║ X S T E G O Z T U R K E Y N S R W H S X M R E ║\n"
        + "║ B E A P R S T J C F M R B I W I K N O Q E V U ║\n"
        + "║ D R H I A C X G O B B L E A N C Z P C I D E R ║\n"
        + "║ K O B T V S N E P H F S T R M O A V N O F S W ║\n"
        + "║ Q L E N Y U T G I I Y B C P W R K H S W I T O ║\n"
        + "║ X E A C R P P L A N T A T I O N I G M N B E I ║\n"
        + "╚═══════════════════════════════════════════════╝\n\n",
        "             ╦  ╔═╗╦  ╦╔═╗╦      ╔═╗ \n"
        + "             ║  ║╣ ╚╗╔╝║╣ ║      ╠═╗\n"
        + "             ╩═╝╚═╝ ╚╝ ╚═╝╩═╝    ╚═╝\n\n"
        + "╔═══════════════════════════════════════════════════╗\n"
        + "║ M O G M I S N A Y G E Y I Z D W C E B A W A T Q B ║\n"
        + "║ O Z G U N E A H X S L F G N I D R O C C A H X V G ║\n"
        + "║ R X Y A X W D V U I M M E D I A T E M T M R B W M ║\n"
        + "║ E Z O Y A D R E T S E Y E K E T U Q Q T N G B R P ║\n"
        + "║ V E A P X E T A N U T R O F N U J K G Z R J E P J ║\n"
        + "║ T B C R G Q K O F Q B E T A R O B A L E N Z G Z E ║\n"
        + "║ V S C N R T R E S P O N S I B L E Z Q P L N I N A ║\n"
        + "║ U Z G X E A I V P C L C U C C S E K E I O R N A P ║\n"
        + "║ M S D F A R N R J G W Y W I M P R O V E M E N T P ║\n"
        + "║ F G L S V G E G A G J N H W X F H U R D E H I N R ║\n"
        + "║ R A I U R J F F E D N E M M O C E R B P K X N O E ║\n"
        + "║ L P C X F C U K F M T N K X D X V L W H U Z G I C ║\n"
        + "║ Z X K S U E B E Y I E H D I S C U S S I O N H T I ║\n"
        + "║ J Y G V X V S S J M D N E H M H I X R W O X W N A ║\n"
        + "║ P W E L B I S S O P M I T A M y O G D P A H W E T ║\n"
        + "║ U N D E R S T A N D P E Q Z K Y H J Y J T I V T E ║\n"
        + "║ P Y A O Z X V I N V E S T I G A T E L U R E I T A ║\n"
        + "║ H O H N W X Z C H B S N O S M V N C I C E F A A M ║\n"
        + "║ E P Y U L Z L S V V P M E P U B L I C A T I O N V ║\n"
        + "║ L B C G X O R X D R C Z J Z F B C J Y E Z N G N L ║\n"
        + "║ N P Y Y H L Z E Y X I F Z E N B G I L F J N B K S ║\n"
        + "║ L N R D J J T N E M T R A P E D G R B Q B N G X M ║\n"
        + "║ T Z S W Z Q G X X T Q F A L N P G F F Y F Z X X F ║\n"
        + "║ N L P H X B X W D K Y T E T H E M S E L V E S D G ║\n"
        + "║ D K C X L M Y B I E W X Q A K F B Q W K W F L B V ║\n"
        + "╚═══════════════════════════════════════════════════╝\n\n",
        "                 ╦  ╔═╗╦  ╦╔═╗╦      ╔═╗ \n"
        + "                 ║  ║╣ ╚╗╔╝║╣ ║        ║\n"
        + "                 ╩═╝╚═╝ ╚╝ ╚═╝╩═╝      ╩\n\n"
        + "╔═══════════════════════════════════════════════════════════╗\n"
        + "║ C N G O M O J L F V B Q J Q G L K D X D L O A T Q P S O P ║\n"
        + "║ H P M S N J C N E X T A L B N B B E A R Z O C I I Y G U I ║\n"
        + "║ M L P A W H U R U O P E M R F K E J G T T K I E A N A M P ║\n"
        + "║ T T I K L C M N R D F T Q G Q D G S N V T O A U A C O I G ║\n"
        + "║ G O F G T G C R I F N T J H P I O W U C W F C N E F O D R ║\n"
        + "║ I Z X G B J A S A H X N B C J N E O C O Z X Y Z G A K A H ║\n"
        + "║ E Y K T E P D R X R P D Y C X O L G N L M T C E D A U P S ║\n"
        + "║ Y B Q T Z A I H O T G L G D H S T J D P C Y R K F G R A Y ║\n"
        + "║ Q H O X W G R W O I M U O R U A R X T L E M A C A W W O C ║\n"
        + "║ U C L I Y D V T E A G B O D P U U B V X Q J X J M K G H O ║\n"
        + "║ D O L S Y S Y X H G I U Z A C R T N U Y K R E O F S I E T ║\n"
        + "║ G K I S B Q B O S W H I A P J K H A Y T E W P M R M Z R K ║\n"
        + "║ P A D A T J G T O F O C I N B C Q B B H U Y Y N P A Z N C ║\n"
        + "║ A U A J U N B U H M T R L I A T C B T T T Y Y A T K T C A ║\n"
        + "║ O A M Z I H Q R H J O J M H I L Y N R H G B N F D B S J N ║\n"
        + "║ E X R M O G Z K T N A H P E L E A A O X U Z W J T M O M I ║\n"
        + "║ Z H A B M A L E S R A F E V A P T N B T E I W Z B Z R L W ║\n"
        + "║ W L C M S G S Y B H L O C Y D G C M T E F H A M S T E R S ║\n"
        + "║ F Z H H U Z Q E H M L T Z M G X L E O Y J P D E K Z C E W ║\n"
        + "║ Y Q M Z P S Z B V X I Q N K P N R E L Q L E R R D R O C P ║\n"
        + "║ Z S O V O A D L Y S G R B D Z F D U A W Q N L P I L N W A ║\n"
        + "║ D P S Y T G M I B C A E O J L Y T D F S G G V H I B I O R ║\n"
        + "║ D O C C C X S Z O O T J C Y L P K R F T X U U O B G H L T ║\n"
        + "║ Z H P I O Y N A P R O F Y T R V G A U H V I W R U K R L B ║\n"
        + "║ L Z S O E G B R T P R T G G B C Q P B N B N C S H U T H M ║\n"
        + "║ G R D K H W O D A I S U M A T O P O P P I H S E W H I W T ║\n"
        + "║ C U N M I D M K P O Q D P D V X R E K H O H K H E H Q P V ║\n"
        + "║ B O R Z E T D A X N Q Q O G F H G L M O S Q U I T O K K M ║\n"
        + "║ M V M O D N A C I L E P C O Y O T E R L Y P A A I L R F W ║\n"
        + "╚═══════════════════════════════════════════════════════════╝\n\n",
        "               ╦  ╔═╗╦  ╦╔═╗╦      ╔═╗ \n"
        + "               ║  ║╣ ╚╗╔╝║╣ ║      ╠═╣\n"
        + "               ╩═╝╚═╝ ╚╝ ╚═╝╩═╝    ╚═╝\n\n"
        + "╔═══════════════════════════════════════════════════════╗\n"
        + "║ E T Y S I A D R E P H O T O L F Y P E P N E A S N E I ║\n"
        + "║ U H T S Y H P F L W O A T U F A U S T R I X I E A D L ║\n"
        + "║ N O S T T O S M P H O E N I X T I C U I A T V A O S E ║\n"
        + "║ L N E R I F T I P S P A R K L E O B O N D M A G I C R ║\n"
        + "║ E B N S R N N N O X S E S A W W E F S C O O T A L O O ║\n"
        + "║ T O O V I K E O L R H U U I L A I T S E L E C H C E C ║\n"
        + "║ I N H R A Y M R F S U G N O R L O T U S T U O T G C I ║\n"
        + "║ R B A M H N E H R Y H O W B L O O E L S M Y N J O I T ║\n"
        + "║ P O I R T O L A S T N I L Y W E L A G A S N L L H R N ║\n"
        + "║ S N S U M M E R E A C N D F H L P R G W Y N S N A T A ║\n"
        + "║ A R S E N R M R V I R E U C E P F N E T T A H E N A M ║\n"
        + "║ R E M A D A M O O O L C L B L L E E I T H R H R I K O ║\n"
        + "║ A E I O N H T U O P X P R E U T T S I D A G I U M C I ║\n"
        + "║ P L T N O G S N H L S A J T B Y O F E S N L I A A O D ║\n"
        + "║ P I H S D N E I R F B A T E A R R L R O N A O L T C A ║\n"
        + "║ L B E T O P A L E S C E N C E R A U R O D S R C I E R ║\n"
        + "║ E U W H O O F G D K R T L N H D T T O E F S C G O W O ║\n"
        + "║ T J F S L I L Y N G L A E P S E S T I S T E V E N H T ║\n"
        + "║ E A E R B A T B U I A G I D P E R E W O B N I A R L C ║\n"
        + "║ E R R Q E Y D Y H O P L U N E A E R P P N D A H G O R ║\n"
        + "║ N O W Y U W T I T I P O A M C I V S I Z R N T C C Y O ║\n"
        + "║ Y C H D L E O T S L L C L O M Y L H N E R I H P P A S ║\n"
        + "║ S K I E B D S P I C O C V L T Y I Y K C S K N E S L P ║\n"
        + "║ H Y D R A R I T Y P O S L I A N S O I O C U R C U T I ║\n"
        + "║ Y N O P H C T A R C S R O Y N G J S E R O H S G E Y K ║\n"
        + "║ A N G Y D L F I N I S H D N S Y B B N A R H S A D L E ║\n"
        + "║ Y C D M E N T G R E A T P L E R L L R P E K A C A C O ║\n"
        + "╚═══════════════════════════════════════════════════════╝\n\n"
    };
    private final String[][] levelAnswer =
    {
        {
            "BIRDWATCHING", "CROSSWORDS", "PARK", "DRIVING", "HOBBIES", "PETS", "RIDING", "POLO", "TOYS", "PLAYING", "ENTERTAINING", "TALKING", "EXERCISE", "EATING", "FOOTBALL", "GOLF", "WALKING", "POKER", "CARDS", "ROWS", "WORDS", "SWORDS", "GOLF", "SEES", "LOGS", "CROSSWORD", "LAYING", "KINGS", "GOOD", "CHIN", "WATCHING", "BIRD"
        },
        {
            "APRIL", "BASEBALL", "BLOSSOMS", "BUDS", "FLOWERS", "GARDENING", "GREEN", "GROWING", "KITE", "MARBLES", "MARCH", "MAY", "NESTING", "PUDDLES", "RAIN", "ROBIN", "SHOWERS", "SUNSHINE", "WINDS", "GENUS", "WORM", "ROLE", "LOWER", "NINE", "STING", "WOLF", "TINY", "VEST", "DRAG", "SHIT", "WINGS", "EARS", "AGREE", "LIDS"
        },
        {
            "MORE", "SENT", "HALF", "SOFT", "WERE", "WISH", "WIFE", "HAND", "WENT", "SOAP", "SOLD", "NEWS", "EASY", "SHUTS", "HUTS", "THEN"
        },
        {
            "ACRONYM", "ELECTRONIC", "SLIME", "AMPLIFIER", "ENERGY", "SOLDER", "AMPLITUDE", "EQUIPMENT", "SPACECRAFT", "ANTENNA", "FLUX", "TELEVISION", "BATTERY", "FREQUENCY", "TUNER", "BROADCAST", "GADGET", "WIRELESS", "BROADCOM", "HEADPHONES", "CAPACITOR", "HOOKED", "CATHODE", "LAPTOP", "CIRCUITS", "LISTEN", "COMMUNICATIONS", "MASTERS", "COMPONENTS", "MODULATION", "DELEGATE", "PLASTIC", "DIODES", "RADIO", "ALAN", "ALAS", "ROAD", "LETS", "CAFE", "LENS"
        },
        {
            "APPLE-PIE", "BREAD", "CASSEROLE", "CIDER", "CORN", "CORNUCOPIA", "CRANBERRIES", "FALL", "GOBBLE", "GRAVY", "HARVEST", "NOVEMBER", "PLANT", "PLANTATION", "PILGRIMS", "POTATOES", "PUDDING", "ROLLS", "STUFFING", "SQUASH", "THANKS", "TURKEY", "LIFT", "CALM", "GRIM", "THANKS", "HATE", "GETS", "ROLE", "RAIN"
        },
        {
            "BEGINNING", "ARRANGEMENT", "IMPROVEMENT", "ACCORDING", "UNFORTUNATE", "YESTERDAY", "IMPOSSIBLE", "RECOMMEND", "INVESTIGATE", "DISCUSSION", "ATTENTION", "ELABORATE", "IMMEDIATE", "DIFFERENCE", "PUBLICATION", "THEMSELVES", "APPRECIATE", "UNDERSTAND", "DEPARTMENT", "RESPONSIBLE", "MORE", "MEDIA", "EYES", "TUNA", "BETA", "RATE", "BEER", "LABOR", "PROVE", "LICK", "BLEW", "TEAM", "GATE", "LURE", "RULE", "SONS", "TRAP"
        },
        {
            "SCORPION", "CAMEL", "FLAMINGO", "DOLPHIN", "PENGUIN", "LEOPARD", "TURKEY", "PELICAN", "EAGLE", "HORSE", "BUFFALO", "PANTHER", "PYTHON", "ZEBRA", "MONKEY", "LIZARD", "IGUANA", "ARMADILLO", "EARTHWORM", "OCTOPUS", "MOUSE", "ELEPHANT", "GIRAFFE", "TURTLE", "KANGAROO", "BIRD", "MOSQUITO", "JAGUAR", "BEAR", "ALLIGATOR", "PARROT", "HAMSTER", "COYOTE", "CHIMPANZEE", "DINOSAUR", "BUTTERFLY", "HIPPOPOTAMUS", "RHINOCEROS", "NEXT", "POUR", "TRUTH", "MELT", "TAIL", "MALES", "LAMB", "PART", "TRAP", "SHUT", "SHIP"
        },
        {
            "ALOE", "ANGEL", "BUNNY", "ANIMATION", "APPLEBLOOM", "APPLEJACK", "APPLETEENY", "APPLOOSSA", "BARBELL", "BONBON", "BRAEBURN", "BRONY", "CANTERLOT", "CARTOON", "CHERRIES", "JUBILEE", "CHIEF", "THUNDER", "THUNDERHOOVES", "CHOCOLATE", "RAIN", "CLOUDSDALE", "COCKATRICE", "COLGATE", "DERPY", "DAISY", "DISCORD", "DOCTOR", "WHOOF", "ELEMENTS", "HARMONY", "EQUESTRIA", "FILLYDELPHIA", "FLUTTERGUY", "FLUTTERSHY", "FRIENDSHIP", "MAGIC", "GENEROSITY", "GRAND", "GALLOPING", "GALA", "GRANNY", "SMITH", "GUMMY", "HAIRITY", "HOITY", "TOITY", "HONESTY", "HOOPS", "HYDRA", "KINDNESS", "LAUGHTER", "LAUREN", "FAUST", "LILY", "LITTLE", "STRONGHEART", "LOTUS", "LOYALTY", "LYRA", "MADAME", "LEFLOUR", "MANEHATTEN", "MANTICORE", "CAKE", "PONY", "NIGHTMARE", "MOON", "OCTAVIA", "OPALESCENCE", "OWLOWICIOUS", "PARASPRITE", "PHOENIX", "PHOTO", "FINISH", "PINKAMINA", "DIANE", "PINKIE", "POISON", "JOKE", "PRINCE", "BLUEBLOOD", "PRINCESS", "CELESTIA", "LUNA", "RAINBOW", "CRASH", "DASH", "RARITY", "ROCKY", "ROSE", "SAPPHIRE", "SHORES", "SCOOTALOO", "SCORE", "SHERIFF", "SILVERSTAR", "LINTSALOT", "SLUGS", "SNAILS", "SOARIN", "SPIKE", "SPITFIRE", "SPITTY", "STEVEN", "MAGNET", "SUMMER", "CELEBRATION", "SWEETY", "BELLE", "GREAT", "POWERFUL", "TRIXIE", "TWILIGHT", "FLOPPLE", "SPARKLE", "URSA", "MINOR", "VINYL", "SCRATCH", "WINONA", "ZECORA", "FATE", "TIPS", "BOND", "TEAR", "EARN", "TRIO", "LAST", "THAN", "RATS", "RADIO", "SEND"
        }
    };

    public WordSearch()
      {

      }

    public void start()
      {
        int ansCounter;
        long timeStart;
        long timerEnd;

        System.out.println("  ██╗    ██╗ ██████╗ ██████╗ ██████╗     ███████╗███████╗ █████╗ ██████╗  ██████╗██╗  ██╗\n"
                + "  ██║    ██║██╔═══██╗██╔══██╗██╔══██╗    ██╔════╝██╔════╝██╔══██╗██╔══██╗██╔════╝██║  ██║\n"
                + "  ██║ █╗ ██║██║   ██║██████╔╝██║  ██║    ███████╗█████╗  ███████║██████╔╝██║     ███████║\n"
                + "  ██║███╗██║██║   ██║██╔══██╗██║  ██║    ╚════██║██╔══╝  ██╔══██║██╔══██╗██║     ██╔══██║\n"
                + "  ╚███╔███╔╝╚██████╔╝██║  ██║██████╔╝    ███████║███████╗██║  ██║██║  ██║╚██████╗██║  ██║\n"
                + "   ╚══╝╚══╝  ╚═════╝ ╚═╝  ╚═╝╚═════╝     ╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝\n"
                + "                                                                                       \n"
                + "\n\n");
        System.out.println("\t\tWELCOME TO WORD SEARCH");
        System.out.println("There are 8 levels in this game");
        System.out.println("Word can be UPWARD,DOWNWARD,\n"
                + "LEFTWARD,RIGHTWARD,\n"
                + "DIAGONAL UP RIGHWARD,DIAGONAL UP LEFTWARD,\n"
                + "DIAGONAL DOWN RIGHWARD,DIAGONAL DOWN LEFTWARD\n");
        System.out.println("Enter \"QUIT\" to Exit from WORD SEARCH");
        System.out.println("Enter \"ENOUGH\" to Skip the Current game");
        System.out.println("Every Word Must contains Minimum 4 Alphabets\n");
        System.out.println("Let the game BEGIN.\n\n");
        timeStart = System.currentTimeMillis(); //Timer Starts
        for (int i = 0; i < levelAnswer.length; i++)
        {
            if (i != 0)
            {
                newPage();
            }
            //Process Starts here
            String userInput;
            System.out.println(level[i]);           //Board at level (i)
//            timeStart = System.currentTimeMillis(); //Timer Starts
            ansCounter = levelAnswer[i].length;
            //Initial Count
            defaultCounter = ansCounter;
            System.out.println("Words  Remaining: " + ansCounter);
            System.out.println("Enter Words\n");
            userInput = scan.next();
            if (userInput.equalsIgnoreCase("ENOUGH") && i != levelAnswer.length - 1)
            {
                //Next level
                continue;
            } else if (userInput.equalsIgnoreCase("QUIT"))
            {
                //Quit the Game
                break;
            }
            int checker = checkWords(userInput, i);
            while (checker == 1)
            {
                //Answer matched
                System.out.println("\nWOW!! You found one of them");
                userAnswers.add(userInput);
                ansCounter--;
                System.out.println("Words  Remaining: " + ansCounter);
                System.out.println("Enter Word\n");
                userInput = scan.next();

                //##########       EXIT MODE    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                if (userInput.equalsIgnoreCase("ENOUGH") || userInput.equalsIgnoreCase("QUIT"))
                {
                    break;
                }
                //##########       EXIT MODE    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

                checker = checkWords(userInput, i);

            }
            while (checker == 0 || checker == -1)
            {
                if (checker == 0)
                {
                    //Wrong Inout
                    System.out.println("Wrong Input , You need to Focus on Board");
                    System.out.println("Words  Remaining: " + ansCounter);
                    System.out.println("Enter Word");
                    userInput = scan.next();

                    //##########       EXIT MODE    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                    if (userInput.equalsIgnoreCase("ENOUGH") || userInput.equalsIgnoreCase("QUIT"))
                    {
                        break;
                    }
                    //##########       EXIT MODE    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

                    checker = checkWords(userInput, i);
                    while (checker == 1)
                    {
                        //Answer matched
                        System.out.println("WOW!! You found one of them");
                        userAnswers.add(userInput);
                        ansCounter--;
                        System.out.println("Words  Remaining: " + ansCounter);
                        System.out.println("Enter Word");
                        userInput = scan.next();

                        //##########       EXIT MODE    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                        if (userInput.equalsIgnoreCase("ENOUGH") || userInput.equalsIgnoreCase("QUIT"))
                        {
                            break;
                        }
                        //##########       EXIT MODE    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

                        checker = checkWords(userInput, i);
                    }
                } else
                {
                    //Already Provided Answer
                    System.out.println("You Already gave: " + userInput.toUpperCase());
                    System.out.println("Please search for new Words");
                    System.out.println("Words  Remaining: " + ansCounter);
                    System.out.println("Enter Word");
                    userInput = scan.next();

                    //##########       EXIT MODE    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                    if (userInput.equalsIgnoreCase("ENOUGH") || userInput.equalsIgnoreCase("QUIT"))
                    {
                        break;
                    }
                    //##########       EXIT MODE    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

                    checker = checkWords(userInput, i);
                    while (checker == 1)
                    {
                        //Answer matched
                        System.out.println("WOW!! You found one of them");
                        userAnswers.add(userInput);
                        ansCounter--;
                        System.out.println("Words  Remaining: " + ansCounter);
                        System.out.println("Enter Word");
                        userInput = scan.next();

                        //##########       EXIT MODE    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                        if (userInput.equalsIgnoreCase("ENOUGH") || userInput.equalsIgnoreCase("QUIT"))
                        {
                            break;
                        }
                        //##########       EXIT MODE    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

                        checker = checkWords(userInput, i);
                    }
                }
            }
            remainCounter = ansCounter;
            if (i == levelAnswer.length - 1)
            {
                userInput = "QUIT";
            }
            if (userInput.equalsIgnoreCase("QUIT") && i == levelAnswer.length - 1)
            {
                delayString("Exiting !!!");
                System.out.println("\n");
                break;
            } else if (userInput.equalsIgnoreCase("ENOUGH") && i != levelAnswer.length - 1)
            {
                delayString("Loading Next Level !!!");
                System.out.println("\n");

//                continue;
            }

            //Reseting Values
            ansCounter = 0;
            userAnswers.clear();
            this.scoreCounter += defaultCounter;
            defaultCounter = 0;
        }
        timerEnd = System.currentTimeMillis();
        scoreCheck(timeStart, timerEnd);

      }

    private void scoreCheck(long startTime, long endTime)
      {
        int wordsCount = scoreCounter /*- remainCounter*/;
        this.userScore = ((100000 - (startTime - endTime)) / 100) * wordsCount;
        System.out.println("Your Score= " + userScore);
        //Checking for HighScore 
        if (userScore > high_score)
        {
            //Setting name and score of HighScorer in Static Variables
            high_score = userScore;
            System.out.println("WOW!!!!! You beat the High Score");
            System.out.println("Enter Your Name <WithOutSpaces> ");
            HS_name = scan.next();
            System.out.println(high_score + " : " + HS_name);
        } else
        {
            System.out.println("High Score : " + HS_name + "-" + high_score);
        }

      }

    private int checkWords(String word, int loopNumber)
      {
        //Matching Answer with all Available answers
        for (int i = 0; i < levelAnswer[loopNumber].length; i++)
        {
            //Already Inputed Answer
            if (userAnswers.contains(word))
            {
                return -1;
            } else if (levelAnswer[loopNumber][i].equalsIgnoreCase(word))
            {
                //GOT the right answer
                return 1;
            }
        }
        //Neither Mathched answer nor Already Provided Answer
        return 0;
      }

  }
