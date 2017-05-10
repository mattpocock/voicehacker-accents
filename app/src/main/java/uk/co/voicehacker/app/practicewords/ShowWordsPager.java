package uk.co.voicehacker.app.practicewords;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import static java.security.AccessController.getContext;

/**
 * Created by Matt on 03-May-17.
 */

public class ShowWordsPager extends AppCompatActivity {

    FragmentPagerAdapter adapterViewPager;
    String wordArr[];
    String title;
    int sentFrom;
    int moreInfoSections[];
    int pageSelected;
    MediaPlayer media;

    int getSoundFile(String word) {
        int sf;

        switch (word) {

            // Unvoiced TH Sounds

            case "bath": sf = R.raw.bath;
                break;
            case "anything": sf = R.raw.anything;
                break;
            case "think": sf = R.raw.think;
                break;
            case "breath": sf = R.raw.breath;
                break;
            case "death": sf = R.raw.death;
                break;
            case "everything": sf = R.raw.everything;
                break;
            case "month": sf = R.raw.month;
                break;
            case "mouth": sf = R.raw.mouth;
                break;
            case "nothing": sf = R.raw.nothing;
                break;
            case "something": sf = R.raw.something;
                break;

            // Voiced TH Sounds

            case "this": sf = R.raw.thisfile;
                break;
            case "than": sf = R.raw.than;
                break;
            case "that": sf = R.raw.that;
                break;
            case "the": sf = R.raw.the;
                break;
            case "themselves": sf = R.raw.themselves;
                break;
            case "mother": sf = R.raw.mother;
                break;
            case "brother": sf = R.raw.brother;
                break;
            case "these": sf = R.raw.these;
                break;
            case "they": sf = R.raw.they;
                break;
            case "together": sf = R.raw.together;
                break;

            // S Sounds

            case "accept": sf = R.raw.accept;
                break;
            case "against": sf = R.raw.against;
                break;
            case "almost": sf = R.raw.almost;
                break;
            case "also": sf = R.raw.also;
                break;
            case "answer": sf = R.raw.answer;
                break;
            case "ask": sf = R.raw.ask;
                break;
            case "asleep": sf = R.raw.asleep;
                break;
            case "beside": sf = R.raw.beside;
                break;
            case "best": sf = R.raw.best;
                break;
            case "breakfast": sf = R.raw.breakfast;
                break;

            // Z Sounds

            case "as": sf = R.raw.as;
                break;
            case "busy": sf = R.raw.busy;
                break;
            case "always": sf = R.raw.always;
                break;
            case "cause": sf = R.raw.cause;
                break;
            case "confuse": sf = R.raw.confuse;
                break;
            case "does": sf = R.raw.does;
                break;
            case "easy": sf = R.raw.easy;
                break;
            case "has": sf = R.raw.has;
                break;
            case "is": sf = R.raw.is;
                break;
            case "jeans": sf = R.raw.jeans;
                break;

            // F Sounds

            case "afraid": sf = R.raw.afraid;
                break;
            case "beautiful": sf = R.raw.beautiful;
                break;
            case "before": sf = R.raw.before;
                break;
            case "boyfriend": sf = R.raw.boyfriend;
                break;
            case "coffee": sf = R.raw.coffee;
                break;
            case "definitely": sf = R.raw.definitely;
                break;
            case "different": sf = R.raw.different;
                break;

            // V Sounds

            case "above": sf = R.raw.above;
                break;
            case "arrive": sf = R.raw.arrive;
                break;
            case "conversation": sf = R.raw.conversation;
                break;
            case "cover": sf = R.raw.cover;
                break;
            case "drive": sf = R.raw.drive;
                break;
            case "even": sf = R.raw.even;
                break;
            case "everyone": sf = R.raw.everyone;
                break;

            // H Sounds

            case "ahead": sf = R.raw.ahead;
                break;
            case "behind": sf = R.raw.behind;
                break;
            case "hair": sf = R.raw.hair;
                break;
            case "half": sf = R.raw.half;
                break;
            case "hall": sf = R.raw.hall;
                break;
            case "hand": sf = R.raw.hand;
                break;
            case "hang": sf = R.raw.hang;
                break;
            case "happy": sf = R.raw.happy;
                break;
            case "hard": sf = R.raw.hard;
                break;

            // SH Sounds

            case "brush": sf = R.raw.brush;
                break;
            case "finish": sf = R.raw.finish;
                break;
            case "flash": sf = R.raw.flash;
                break;
            case "push": sf = R.raw.push;
                break;
            case "relationship": sf = R.raw.relationship;
                break;
            case "rush": sf = R.raw.rush;
                break;
            case "shadow": sf = R.raw.shadow;
                break;
            case "shake": sf = R.raw.shake;
                break;
            case "she": sf = R.raw.she;
                break;

            // ZH Sounds

            case "measure": sf = R.raw.measure;
                break;
            case "treasure": sf = R.raw.treasure;
                break;
            case "pleasure": sf = R.raw.pleasure;
                break;
            case "vision": sf = R.raw.vision;
                break;
            case "casual": sf = R.raw.casual;
                break;
            case "revision": sf = R.raw.revision;
                break;
            case "occasion": sf = R.raw.occasion;
                break;
            case "division": sf = R.raw.division;
                break;
            case "decision": sf = R.raw.decision;
                break;

            // P Sounds

            case "drop": sf = R.raw.drop;
                break;
            case "empty": sf = R.raw.empty;
                break;
            case "escape": sf = R.raw.escape;
                break;
            case "except": sf = R.raw.except;
                break;
            case "flip": sf = R.raw.flip;
                break;
            case "gasp": sf = R.raw.gasp;
                break;
            case "happen": sf = R.raw.happen;
                break;
            case "hope": sf = R.raw.hope;
                break;
            case "help": sf = R.raw.help;
                break;
            case "important": sf = R.raw.important;
                break;

            // B Sounds

            case "by": sf = R.raw.by;
                break;
            case "eyebrow": sf = R.raw.eyebrow;
                break;
            case "job": sf = R.raw.job;
                break;
            case "maybe": sf = R.raw.maybe;
                break;
            case "number": sf = R.raw.number;
                break;
            case "possible": sf = R.raw.possible;
                break;
            case "probably": sf = R.raw.probably;
                break;
            case "problem": sf = R.raw.problem;
                break;
            case "remember": sf = R.raw.remember;
                break;
            case "table": sf = R.raw.table;
                break;

            // T Sounds

            case "forget": sf = R.raw.forget;
                break;
            case "front": sf = R.raw.front;
                break;
            case "great": sf = R.raw.great;
                break;
            case "hospital": sf = R.raw.hospital;
                break;
            case "jacket": sf = R.raw.jacket;
                break;

            // D Sounds

            case "admit": sf = R.raw.admit;
                break;
            case "already": sf = R.raw.already;
                break;
            case "around": sf = R.raw.around;
                break;
            case "blonde": sf = R.raw.blonde;
                break;
            case "body": sf = R.raw.body;
                break;
            case "card": sf = R.raw.card;
                break;
            case "consider": sf = R.raw.consider;
                break;
            case "dance": sf = R.raw.dance;
                break;

            // K Sounds

            case "check": sf = R.raw.check;
                break;
            case "dark": sf = R.raw.dark;
                break;
            case "kept": sf = R.raw.kept;
                break;
            case "kick": sf = R.raw.kick;
                break;

            // G Sounds

            case "again": sf = R.raw.again;
                break;
            case "ago": sf = R.raw.ago;
                break;
            case "anger": sf = R.raw.anger;
                break;
            case "began": sf = R.raw.began;
                break;
            case "begin": sf = R.raw.begin;
                break;
            case "drag": sf = R.raw.drag;
                break;
            case "figure": sf = R.raw.figure;
                break;

            // CH Sounds

            case "approach": sf = R.raw.approach;
                break;
            case "catch": sf = R.raw.catchfile;
                break;
            case "chance": sf = R.raw.chance;
                break;
            case "chase": sf = R.raw.chase;
                break;
            case "chest": sf = R.raw.chest;
                break;
            case "child": sf = R.raw.child;
                break;

            // J Sounds

            case "enjoy": sf = R.raw.enjoy;
                break;
            case "joke": sf = R.raw.joke;
                break;
            case "jump": sf = R.raw.jump;
                break;
            case "edge": sf = R.raw.edge;
                break;
            case "age": sf = R.raw.age;
                break;
            case "college": sf = R.raw.college;
                break;

            // M Sounds

            case "anymore": sf = R.raw.anymore;
                break;
            case "arm": sf = R.raw.arm;
                break;
            case "became": sf = R.raw.became;
                break;
            case "bedroom": sf = R.raw.bedroom;
                break;
            case "bottom": sf = R.raw.bottom;
                break;
            case "climb": sf = R.raw.climb;
                break;
            case "come": sf = R.raw.come;
                break;

            // N Sounds

            case "band": sf = R.raw.band;
                break;
            case "been": sf = R.raw.been;
                break;
            case "change": sf = R.raw.change;
                break;
            case "children": sf = R.raw.children;
                break;
            case "continue": sf = R.raw.continuefile;
                break;
            case "control": sf = R.raw.control;
                break;

            // Z Sounds

            case "evening": sf = R.raw.evening;
                break;
            case "finger": sf = R.raw.finger;
                break;
            case "hung": sf = R.raw.hung;
                break;
            case "blink": sf = R.raw.blink;
                break;
            case "drink": sf = R.raw.drink;
                break;
            case "pink": sf = R.raw.pink;
                break;
            case "thank": sf = R.raw.thank;
                break;
            case "long": sf = R.raw.longfile;
                break;
            case "morning": sf = R.raw.morning;
                break;

            // Light L

            case "life": sf = R.raw.life;
                break;
            case "lean": sf = R.raw.lean;
                break;
            case "lead": sf = R.raw.lead;
                break;
            case "please": sf = R.raw.please;
                break;

            // Dark L

            case "bottle": sf = R.raw.bottle;
                break;
            case "couple": sf = R.raw.couple;
                break;
            case "giggle": sf = R.raw.giggle;
                break;
            case "call": sf = R.raw.call;
                break;
            case "bill": sf = R.raw.bill;
                break;
            case "tell": sf = R.raw.tell;
                break;
            case "shall": sf = R.raw.shall;
                break;

            // R Sounds

            case "carry": sf = R.raw.carry;
                break;
            case "cry": sf = R.raw.cry;
                break;
            case "dry": sf = R.raw.dry;
                break;
            case "every": sf = R.raw.every;
                break;
            case "right": sf = R.raw.right;
                break;
            case "round": sf = R.raw.round;
                break;
            case "sorry": sf = R.raw.sorry;
                break;

            // Y Sounds

            case "UK": sf = R.raw.uk;
                break;
            case "yell": sf = R.raw.yell;
                break;
            case "yes": sf = R.raw.yes;
                break;
            case "yet": sf = R.raw.yet;
                break;
            case "yourself": sf = R.raw.yourself;
                break;
            case "USA": sf = R.raw.usa;
                break;

            // W Sounds

            case "one": sf = R.raw.one;
                break;
            case "once": sf = R.raw.once;
                break;
            case "what": sf = R.raw.what;
                break;
            case "why": sf = R.raw.why;
                break;
            case "where": sf = R.raw.where;
                break;
            case "forward": sf = R.raw.forward;
                break;
            case "however": sf = R.raw.however;
                break;
            case "sweet": sf = R.raw.sweet;
                break;
            case "quite": sf = R.raw.quite;
                break;
            case "quiet": sf = R.raw.quiet;
                break;

            // Short 'Ah' Sound

            case "attack": sf = R.raw.attack;
                break;
            case "cat": sf = R.raw.cat;
                break;
            case "stand": sf = R.raw.stand;
                break;
            case "cancel": sf = R.raw.cancel;
                break;
            case "back": sf = R.raw.back;
                break;
            case "add": sf = R.raw.add;
                break;
            case "fashion": sf = R.raw.fashion;
                break;
            case "lamp": sf = R.raw.lamp;
                break;
            case "bag": sf = R.raw.bag;
                break;
            case "had": sf = R.raw.had;
                break;

            // Short 'Eh' Sound

            case "guest": sf = R.raw.guest;
                break;
            case "bet": sf = R.raw.bet;
                break;
            case "get": sf = R.raw.get;
                break;
            case "friend": sf = R.raw.friend;
                break;
            case "lend": sf = R.raw.lend;
                break;
            case "mend": sf = R.raw.mend;
                break;
            case "pet": sf = R.raw.pet;
                break;
            case "many": sf = R.raw.many;
                break;
            case "expensive": sf = R.raw.expensive;
                break;
            case "very": sf = R.raw.very;
                break;

            // Short 'Ih' Sound

            case "bit": sf = R.raw.bit;
                break;
            case "fill": sf = R.raw.fill;
                break;
            case "still": sf = R.raw.still;
                break;
            case "hill": sf = R.raw.hill;
                break;
            case "city": sf = R.raw.city;
                break;
            case "biscuit": sf = R.raw.biscuit;
                break;
            case "ring": sf = R.raw.ring;
                break;
            case "music": sf = R.raw.music;
                break;
            case "kitchen": sf = R.raw.kitchen;
                break;

            // Short 'Ooh' Sound

            case "book": sf = R.raw.book;
                break;
            case "could": sf = R.raw.could;
                break;
            case "couldn't": sf = R.raw.couldnt;
                break;
            case "foot": sf = R.raw.foot;
                break;
            case "full": sf = R.raw.full;
                break;
            case "good": sf = R.raw.good;
                break;
            case "look": sf = R.raw.look;
                break;
            case "pull": sf = R.raw.pull;
                break;
            case "put": sf = R.raw.put;
                break;
            case "shook": sf = R.raw.shook;
                break;

            // Short 'Oh' Sound

            case "won": sf = R.raw.won;
                break;
            case "off": sf = R.raw.off;
                break;
            case "not": sf = R.raw.not;
                break;
            case "cost": sf = R.raw.cost;
                break;
            case "hot": sf = R.raw.hot;
                break;
            case "dog": sf = R.raw.dog;
                break;
            case "sock": sf = R.raw.sock;
                break;
            case "sausage": sf = R.raw.sausage;
                break;
            case "pot": sf = R.raw.pot;
                break;
            case "chocolate": sf = R.raw.chocolate;
                break;

            // Short Uh

            case "button": sf = R.raw.button;
                break;
            case "just": sf = R.raw.just;
                break;
            case "hut": sf = R.raw.hut;
                break;
            case "other": sf = R.raw.other;
                break;
            case "government": sf = R.raw.government;
                break;
            case "blood": sf = R.raw.blood;
                break;
            case "bus": sf = R.raw.bus;
                break;
            case "chuckle": sf = R.raw.chuckle;
                break;
            case "enough": sf = R.raw.enough;
                break;

            // Schwa

            case "comma": sf = R.raw.comma;
                break;
            case "better": sf = R.raw.better;
                break;
            case "complete": sf = R.raw.complete;
                break;
            case "station": sf = R.raw.station;
                break;
            case "england": sf = R.raw.england;
                break;
            case "doctor": sf = R.raw.doctor;
                break;
            case "delicate": sf = R.raw.delicate;
                break;
            case "allow": sf = R.raw.allow;
                break;
            case "forgot": sf = R.raw.forgot;
                break;
            case "local": sf = R.raw.local;
                break;

            // Long 'Ee' Sound

            case "free": sf = R.raw.free;
                break;
            case "keep": sf = R.raw.keep;
                break;
            case "mean": sf = R.raw.mean;
                break;
            case "clean": sf = R.raw.clean;
                break;
            case "speech": sf = R.raw.speech;
                break;
            case "need": sf = R.raw.need;
                break;
            case "feed": sf = R.raw.feed;
                break;
            case "seen": sf = R.raw.seen;
                break;
            case "believe": sf = R.raw.believe;
                break;
            case "thirteen": sf = R.raw.thirteen;
                break;

            // Long 'Oo' Sound

            case "blue": sf = R.raw.blue;
                break;
            case "food": sf = R.raw.food;
                break;
            case "new": sf = R.raw.newfile;
                break;
            case "who": sf = R.raw.who;
                break;
            case "queue": sf = R.raw.queue;
                break;
            case "few": sf = R.raw.few;
                break;
            case "group": sf = R.raw.group;
                break;
            case "do": sf = R.raw.dofile;
                break;
            case "movie": sf = R.raw.movie;
                break;
            case "shoe": sf = R.raw.shoe;
                break;

            // Long 'Ur' Sound

            case "hurt": sf = R.raw.hurt;
                break;
            case "shirt": sf = R.raw.shirt;
                break;
            case "first": sf = R.raw.first;
                break;
            case "work": sf = R.raw.work;
                break;
            case "worse": sf = R.raw.worse;
                break;
            case "were": sf = R.raw.were;
                break;
            case "urgent": sf = R.raw.urgent;
                break;
            case "word": sf = R.raw.word;
                break;
            case "earth": sf = R.raw.earth;
                break;

            // Long 'Or' Sound

            case "tall": sf = R.raw.tall;
                break;
            case "more": sf = R.raw.more;
                break;
            case "thought": sf = R.raw.thought;
                break;
            case "caution": sf = R.raw.caution;
                break;
            case "order": sf = R.raw.order;
                break;
            case "short": sf = R.raw.shortfile;
                break;
            case "taught": sf = R.raw.taught;
                break;
            case "north": sf = R.raw.north;
                break;
            case "august": sf = R.raw.august;
                break;

            // Long 'Ah' Sound

            case "fast": sf = R.raw.fast;
                break;
            case "car": sf = R.raw.car;
                break;
            case "staff": sf = R.raw.staff;
                break;
            case "photograph": sf = R.raw.photograph;
                break;
            case "past": sf = R.raw.past;
                break;
            case "calm": sf = R.raw.calm;
                break;
            case "after": sf = R.raw.after;
                break;
            case "heart": sf = R.raw.heart;
                break;
            case "party": sf = R.raw.party;
                break;

            // Ay Sound

            case "same": sf = R.raw.same;
                break;
            case "fame": sf = R.raw.fame;
                break;
            case "rain": sf = R.raw.rain;
                break;
            case "hey": sf = R.raw.hey;
                break;
            case "game": sf = R.raw.game;
                break;
            case "brain": sf = R.raw.brain;
                break;
            case "amaze": sf = R.raw.amaze;
                break;
            case "hate": sf = R.raw.hate;
                break;
            case "case": sf = R.raw.casefile;
                break;
            case "aim": sf = R.raw.aim;
                break;

            // Igh Sound

            case "fine": sf = R.raw.fine;
                break;
            case "line": sf = R.raw.line;
                break;
            case "time": sf = R.raw.time;
                break;
            case "mine": sf = R.raw.mine;
                break;
            case "kind": sf = R.raw.kind;
                break;
            case "find": sf = R.raw.find;
                break;
            case "sign": sf = R.raw.sign;
                break;
            case "die": sf = R.raw.die;
                break;
            case "my": sf = R.raw.my;
                break;
            case "hi": sf = R.raw.hi;
                break;

            // Ow Sound

            case "out": sf = R.raw.out;
                break;
            case "about": sf = R.raw.about;
                break;
            case "now": sf = R.raw.now;
                break;
            case "how": sf = R.raw.how;
                break;
            case "power": sf = R.raw.power;
                break;
            case "found": sf = R.raw.found;
                break;
            case "loud": sf = R.raw.loud;
                break;
            case "shower": sf = R.raw.shower;
                break;
            case "proud": sf = R.raw.proud;
                break;
            case "without": sf = R.raw.without;
                break;

            // O Sound

            case "home": sf = R.raw.home;
                break;
            case "grow": sf = R.raw.grow;
                break;
            case "show": sf = R.raw.show;
                break;
            case "know": sf = R.raw.know;
                break;
            case "flow": sf = R.raw.flow;
                break;
            case "OK": sf = R.raw.ok;
                break;
            case "open": sf = R.raw.open;
                break;
            case "location": sf = R.raw.location;
                break;
            case "load": sf = R.raw.load;
                break;
            case "cold": sf = R.raw.cold;
                break;

            // O Sound

            case "ear": sf = R.raw.ear;
                break;
            case "real": sf = R.raw.real;
                break;
            case "area": sf = R.raw.area;
                break;
            case "beer": sf = R.raw.beer;
                break;
            case "dear": sf = R.raw.dear;
                break;
            case "hear": sf = R.raw.hear;
                break;
            case "nearly": sf = R.raw.nearly;
                break;
            case "year": sf = R.raw.year;
                break;
            case "weird": sf = R.raw.weird;
                break;
            case "really": sf = R.raw.cold;
                break;

            // Air Sound

            case "chair": sf = R.raw.chair;
                break;
            case "air": sf = R.raw.air;
                break;
            case "care": sf = R.raw.care;
                break;
            case "there": sf = R.raw.there;
                break;
            case "mary": sf = R.raw.mary;
                break;
            case "dare": sf = R.raw.dare;
                break;
            case "rare": sf = R.raw.rare;
                break;
            case "nightmare": sf = R.raw.nightmare;
                break;
            case "share": sf = R.raw.share;
                break;

            // Oy Sound

            case "boy": sf = R.raw.boy;
                break;
            case "coin": sf = R.raw.coin;
                break;
            case "foil": sf = R.raw.foil;
                break;
            case "noise": sf = R.raw.noise;
                break;
            case "toy": sf = R.raw.toy;
                break;
            case "choice": sf = R.raw.choice;
                break;
            case "avoid": sf = R.raw.avoid;
                break;
            case "join": sf = R.raw.join;
                break;
            case "point": sf = R.raw.point;
                break;
            case "voice": sf = R.raw.voice;
                break;

            // Ure Sound

            case "pure": sf = R.raw.pure;
                break;
            case "cure": sf = R.raw.cure;
                break;
            case "endure": sf = R.raw.endure;
                break;
            case "jewel": sf = R.raw.jewel;
                break;
            case "usual": sf = R.raw.usual;
                break;
            case "fury": sf = R.raw.fury;
                break;
            case "mature": sf = R.raw.mature;
                break;
            case "during": sf = R.raw.during;
                break;
            case "secure": sf = R.raw.secure;
                break;
            case "curious": sf = R.raw.curious;
                break;

            default: sf = 0;
                break;
        }
        return sf;
    };

    public String getTitlefromDesc(int desc) {

        String t;

        switch (desc) {
            case R.string.desc_morecoming: t = "More Coming Soon";
                break;
            case R.string.desc_closedjaw: t = "Jaw: Closed";
                break;
            case R.string.desc_midjaw: t = "Jaw: Semi-Open";
                break;
            case R.string.desc_openjaw: t = "Jaw: Open";
                break;
            case R.string.desc_longvowels: t = "Long Vowel";
                break;
            case R.string.desc_shortvowels: t = "Short Vowel";
                break;
            case R.string.desc_diphthongs: t = "Diphthong";
                break;
            case R.string.desc_roundedlips: t = "Lips: Rounded";
                break;
            case R.string.desc_neutrallips: t = "Lips: Neutral";
                break;
            case R.string.desc_spreadlips: t = "Lips: Spread";
                break;
            case R.string.desc_placementback: t = "Placement: Back";
                break;
            case R.string.desc_placementcentral: t = "Placement: Central";
                break;
            case R.string.desc_placementfront: t = "Placement: Front";
                break;
            case R.string.desc_fricatve: t = "Fricative";
                break;
            case R.string.desc_plosive: t = "Plosive";
                break;
            case R.string.desc_affricate: t = "Affricate";
                break;
            case R.string.desc_nasal: t = "Nasal";
                break;
            case R.string.desc_approximant: t = "Approximant";
                break;
            case R.string.desc_voiced: t = "Voiced";
                break;
            case R.string.desc_unvoiced: t = "Unvoiced";
                break;
            case R.string.desc_thsound: t = "Dental";
                break;
            case R.string.desc_szsounds: t = "Alveolar";
                break;
            case R.string.desc_fvsounds: t = "Labiodental";
                break;
            case R.string.desc_hsound: t = "Glottal";
                break;
            case R.string.desc_shzhsounds: t = "Palato-Alveolar";
                break;
            case R.string.desc_pbsounds: t = "Bilabial";
                break;
            case R.string.desc_tdsounds: t = "Alveolar";
                break;
            case R.string.desc_kgsounds: t = "Velar";
                break;
            case R.string.desc_msounds: t = "Bilabial";
                break;
            case R.string.desc_nsounds: t = "Alveolar";
                break;
            case R.string.desc_ngsounds: t = "Velar";
                break;
            case R.string.desc_lsounds: t = "Alveolar Lateral";
                break;
            case R.string.desc_darkl: t = "Velar";
                break;
            case R.string.desc_rsound: t = "Postalveolar";
                break;
            case R.string.desc_ysound: t = "Palatal";
                break;
            case R.string.desc_wsound: t = "Labio-Velar";
                break;
            case R.string.desc_aylips: t = "Lips: Spread to Neutral";
                break;
            case R.string.desc_ighlips: t = "Lips: Spread to Neutral";
                break;
            case R.string.desc_airlips: t = "Lips: Spread to Neutral";
                break;
            case R.string.desc_owlips: t = "Lips: Spread to Rounded";
                break;
            case R.string.desc_olips: t = "Lips: Neutral to Rounded";
                break;
            case R.string.desc_oylips: t = "Lips: Rounded to Neutral";
                break;
            case R.string.desc_ighjaw: t = "Jaw: Open to Closed";
                break;
            case R.string.desc_owjaw: t = "Jaw: Open to Semi-Open";
                break;
            case R.string.desc_owplace: t = "Placement: Front to Back";
                break;
            case R.string.desc_oplace: t = "Placement: Central to Back";
                break;
            case R.string.desc_earplace: t = "Placement: Front to Central";
                break;
            case R.string.desc_airplace: t = "Placement: Front to Central";
                break;
            case R.string.desc_oyplace: t = "Placement: Back to Front";
                break;
            case R.string.desc_schwa: t = "The Most Important Vowel?";
                break;
            default: t = "Unknown Title";
                break;
        }

        return t;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_words_pager);
        final ViewPager vpPager = (ViewPager) findViewById(R.id.showwordsvpager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);


        // Get Intent Stuff

        Intent intent = getIntent();
        wordArr = intent.getStringArrayExtra("wordArr");
        title = intent.getStringExtra("title");
        sentFrom = intent.getIntExtra("sentFrom", 0);
        moreInfoSections = intent.getIntArrayExtra("moreInfoSections");

        // FIRST TIME



        if (getSoundFile(wordArr[0]) != 0) {

            if (media != null) {
                media.release();
            }

            media = MediaPlayer.create(getApplicationContext(), getSoundFile(wordArr[0]));
            media.start();

            media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    media.release();
                }
            });
        }

        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                pageSelected = position;
                if (getSoundFile(wordArr[position]) != 0) {

                    if (media != null) {
                        media.release();
                    }

                    media = MediaPlayer.create(getApplicationContext(), getSoundFile(wordArr[position]));
                    media.start();

                    media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            media.release();
                        }
                    });
                }
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });

        final Button bBtn = (Button) findViewById(R.id.backbtn);
        final ImageButton nBtn = (ImageButton) findViewById(R.id.nextbtn);
        final ImageButton pBtn = (ImageButton) findViewById(R.id.prevbtn);
        nBtn.setSoundEffectsEnabled(false);
        pBtn.setSoundEffectsEnabled(false);

        nBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vpPager.setCurrentItem(pageSelected + 1);
            }
        });

        pBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vpPager.setCurrentItem(pageSelected - 1);
            }
        });

        bBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtra("sentFrom", sentFrom);
                if (media != null) {
                    media.release();
                }
                startActivity(i);
            }
        });

        LinearLayout moreinfoll = (LinearLayout) findViewById(R.id.moreinfo);

        TextView titleview = (TextView) findViewById(R.id.moreinfotitle);
        titleview.setText(title);

        int insertID = 0; // 1 Because of title, 0 if none

        for (int i = 0; i < moreInfoSections.length; i++) {

            // Subtitle

            TextView subtitle = new TextView(getApplicationContext());
            subtitle.setId(i);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            if (i == 0) {
                params.topMargin = 24;
            }
            params.bottomMargin = 24;
            moreinfoll.addView(subtitle, insertID, params);
            TextView insertedSub = (TextView) findViewById(i);
            insertedSub.setText(getTitlefromDesc(moreInfoSections[i]));
            insertedSub.setTextAppearance(this, R.style.MoreInfoSub);
            insertID++;

            // Body

            TextView body = new TextView(getApplicationContext());
            body.setId(i + 1000);
            body.setVisibility(View.GONE);
            LinearLayout.LayoutParams bodyparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            bodyparams.bottomMargin = 24;
            moreinfoll.addView(body, insertID, bodyparams);
            TextView insertedBody = (TextView) findViewById(i + 1000);
            insertedBody.setText(moreInfoSections[i]);
            insertedBody.setTextAppearance(this, R.style.MoreInfoBody);
            insertID++;

            TextView bodypreview = new TextView(getApplicationContext());
            bodypreview.setId(i + 3000);
            LinearLayout.LayoutParams prevparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            prevparams.bottomMargin = 24;
            moreinfoll.addView(bodypreview, insertID, prevparams);
            TextView insertedBodyPrev = (TextView) findViewById(i + 3000);
            String str = getResources().getString(moreInfoSections[i]);
            insertedBodyPrev.setText(str.substring(0,30) + "...");
            insertedBodyPrev.setTextAppearance(this, R.style.MoreInfoBody);
            insertedBodyPrev.setTextColor(getResources().getColor(R.color.darkGrey));
            insertID++;

            Button moreinfobtn = new Button(getApplicationContext(), null, R.drawable.moreinfobtn);
            moreinfobtn.setId(i + 2000);
            moreinfobtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.moreinfobtn));
            LinearLayout.LayoutParams btnparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            btnparams.bottomMargin = 24;
            moreinfoll.addView(moreinfobtn, insertID, btnparams);
            Button insertedBtn = (Button) findViewById(i + 2000);
            insertedBtn.setTextSize(16);
            insertedBtn.setText("READ MORE");
            insertedBtn.setTextColor(getResources().getColor(R.color.colorPrimary));

            final int listenerID = i;
            insertedBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Button btn = (Button) findViewById(listenerID + 2000);
                    btn.setVisibility(View.GONE);
                    TextView body = (TextView) findViewById(listenerID + 1000);
                    body.setVisibility(View.VISIBLE);
                    TextView prevbody = (TextView) findViewById(listenerID + 3000);
                    prevbody.setVisibility(View.GONE);
                }
            });
            insertID++;

        }

    }

    // ...

    public class MyPagerAdapter extends FragmentPagerAdapter {


        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            Intent intent = getIntent();
            wordArr = intent.getStringArrayExtra("wordArr");
            return wordArr.length;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            return ShowWordsFragment.newInstance(title, wordArr, position);
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }

}
