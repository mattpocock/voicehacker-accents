package uk.co.voicehacker.app.practicewords;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Arrays;

import static java.security.AccessController.getContext;

/**
 * Created by Matt on 03-May-17.
 */

public class ShowWordsPager extends AppCompatActivity {

    FragmentPagerAdapter adapterViewPager;
    String title;
    int sentFrom;
    int moreInfoSections[];
    int pageSelected;
    MediaPlayer media;
    boolean purchased001;
    SharedPreferences sharedPref;
    boolean starshowing;

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
            case "thumb": sf = R.raw.thumb;
                break;
            case "thistle": sf = R.raw.thistle;
                break;
            case "path": sf = R.raw.path;
                break;
            case "moth": sf = R.raw.moth;
                break;
            case "worth": sf = R.raw.worth;
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
            case "those": sf = R.raw.those;
                break;
            case "them": sf = R.raw.them;
                break;
            case "with": sf = R.raw.with;
                break;
            case "bathe": sf = R.raw.bathe;
                break;
            case "father": sf = R.raw.father;
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
            case "simple": sf = R.raw.simple;
                break;
            case "cast": sf = R.raw.cast;
                break;
            case "mast": sf = R.raw.mast;
                break;
            case "feast": sf = R.raw.feast;
                break;
            case "mess": sf = R.raw.mess;
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
            case "feels": sf = R.raw.feels;
                break;
            case "rails": sf = R.raw.rails;
                break;
            case "wands": sf = R.raw.wands;
                break;
            case "was": sf = R.raw.was;
                break;
            case "rose": sf = R.raw.rose;
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
            case "fight": sf = R.raw.fight;
                break;
            case "fell": sf = R.raw.fell;
                break;
            case "feel": sf = R.raw.feel;
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
            case "save": sf = R.raw.save;
                break;
            case "veil": sf = R.raw.veil;
                break;
            case "never": sf = R.raw.never;
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
            case "whose": sf = R.raw.whose;
                break;
            case "perhaps": sf = R.raw.perhaps;
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
            case "shame": sf = R.raw.shame;
                break;
            case "shape": sf = R.raw.shape;
                break;
            case "shine": sf = R.raw.shine;
                break;
            case "leash": sf = R.raw.leash;
                break;
            case "fish": sf = R.raw.fish;
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
            case "asia": sf = R.raw.asia;
                break;
            case "closure": sf = R.raw.closure;
                break;
            case "version": sf = R.raw.version;
                break;
            case "explosion": sf = R.raw.explosion;
                break;
            case "conclusion": sf = R.raw.conclusion;
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
            case "possess": sf = R.raw.possess;
                break;
            case "prize": sf = R.raw.prize;
                break;
            case "cape": sf = R.raw.cape;
                break;
            case "mop": sf = R.raw.mop;
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
            case "rub": sf = R.raw.rub;
                break;
            case "pub": sf = R.raw.pub;
                break;
            case "cable": sf = R.raw.cable;
                break;
            case "bomb": sf = R.raw.bomb;
                break;
            case "boss": sf = R.raw.boss;
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
            case "toast": sf = R.raw.toast;
                break;
            case "top": sf = R.raw.top;
                break;
            case "coat": sf = R.raw.coat;
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
            case "don't": sf = R.raw.dont;
                break;
            case "breed": sf = R.raw.breed;
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
            case "socks": sf = R.raw.socks;
                break;
            case "creek": sf = R.raw.creek;
                break;
            case "can't": sf = R.raw.cant;
                break;
            case "coast": sf = R.raw.coast;
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
            case "grant": sf = R.raw.grant;
                break;
            case "beg": sf = R.raw.beg;
                break;
            case "fog": sf = R.raw.fog;
                break;
            case "bug": sf = R.raw.bug;
                break;
            case "agree": sf = R.raw.agree;
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
            case "match": sf = R.raw.match;
                break;
            case "inches": sf = R.raw.inches;
                break;
            case "picture": sf = R.raw.picture;
                break;
            case "lunch": sf = R.raw.lunch;
                break;
            case "touch": sf = R.raw.touch;
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
            case "agent": sf = R.raw.agent;
                break;
            case "object": sf = R.raw.object;
                break;
            case "project": sf = R.raw.project;
                break;
            case "bridge": sf = R.raw.bridge;
                break;
            case "damage": sf = R.raw.damage;
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
            case "tomato": sf = R.raw.tomato;
                break;
            case "animal": sf = R.raw.animal;
                break;
            case "famous": sf = R.raw.famous;
                break;
            case "stream": sf = R.raw.stream;
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
            case "pony": sf = R.raw.pony;
                break;
            case "frown": sf = R.raw.frown;
                break;
            case "moon": sf = R.raw.moon;
                break;
            case "nine": sf = R.raw.nine;
                break;

            // NG Sounds

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
            case "bring": sf = R.raw.bring;
                break;
            case "sing": sf = R.raw.sing;
                break;
            case "spring": sf = R.raw.spring;
                break;
            case "king": sf = R.raw.king;
                break;
            case "swing": sf = R.raw.swing;
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
            case "belly": sf = R.raw.belly;
                break;
            case "sailing": sf = R.raw.sailing;
                break;
            case "alarm": sf = R.raw.alarm;
                break;
            case "police": sf = R.raw.police;
                break;
            case "family": sf = R.raw.family;
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
            case "wallpaper": sf = R.raw.wallpaper;
                break;
            case "elbow": sf = R.raw.elbow;
                break;
            case "pencil": sf = R.raw.pencil;
                break;
            case "owl": sf = R.raw.owl;
                break;
            case "muscle": sf = R.raw.muscle;
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
            case "carrot": sf = R.raw.carrot;
                break;
            case "giraffe": sf = R.raw.giraffe;
                break;
            case "pirate": sf = R.raw.pirate;
                break;
            case "camera": sf = R.raw.camera;
                break;
            case "syrup": sf = R.raw.syrup;
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
            case "union": sf = R.raw.union;
                break;
            case "useful": sf = R.raw.useful;
                break;
            case "yesterday": sf = R.raw.yesterday;
                break;
            case "yoghurt": sf = R.raw.yoghurt;
                break;
            case "unique": sf = R.raw.unique;
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
            case "award": sf = R.raw.award;
                break;
            case "homework": sf = R.raw.homework;
                break;
            case "reward": sf = R.raw.reward;
                break;
            case "microwave": sf = R.raw.microwave;
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
            case "matter": sf = R.raw.matter;
                break;
            case "bat": sf = R.raw.bat;
                break;
            case "balance": sf = R.raw.balance;
                break;
            case "national": sf = R.raw.national;
                break;
            case "actual": sf = R.raw.actual;
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
            case "mention": sf = R.raw.mention;
                break;
            case "head": sf = R.raw.head;
                break;
            case "bell": sf = R.raw.bell;
                break;
            case "extra": sf = R.raw.extra;
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
            case "mist": sf = R.raw.mist;
                break;
            case "building": sf = R.raw.building;
                break;
            case "listen": sf = R.raw.listen;
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
            case "soot": sf = R.raw.soot;
                break;
            case "cook": sf = R.raw.cook;
                break;
            case "stood": sf = R.raw.stood;
                break;
            case "would": sf = R.raw.would;
                break;
            case "hood": sf = R.raw.hood;
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
            case "stop": sf = R.raw.stop;
                break;
            case "cotton": sf = R.raw.cotton;
                break;
            case "lost": sf = R.raw.lost;
                break;
            case "posh": sf = R.raw.posh;
                break;
            case "dock": sf = R.raw.dock;
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
            case "much": sf = R.raw.much;
                break;
            case "such": sf = R.raw.such;
                break;
            case "rust": sf = R.raw.rust;
                break;
            case "rough": sf = R.raw.rough;
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
            case "amount": sf = R.raw.amount;
                break;
            case "information": sf = R.raw.information;
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
            case "peace": sf = R.raw.peace;
                break;
            case "green": sf = R.raw.green;
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
            case "mood": sf = R.raw.mood;
                break;
            case "clue": sf = R.raw.clue;
                break;
            case "renew": sf = R.raw.renew;
                break;
            case "balloon": sf = R.raw.balloon;
                break;
            case "due": sf = R.raw.due;
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
            case "service": sf = R.raw.service;
                break;
            case "third": sf = R.raw.third;
                break;
            case "murder": sf = R.raw.murder;
                break;
            case "birth": sf = R.raw.birth;
                break;
            case "earn": sf = R.raw.earn;
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
            case "awful": sf = R.raw.awful;
                break;
            case "alright": sf = R.raw.alright;
                break;
            case "dawn": sf = R.raw.dawn;
                break;
            case "born": sf = R.raw.born;
                break;
            case "torn": sf = R.raw.torn;
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
            case "sharp": sf = R.raw.sharp;
                break;
            case "master": sf = R.raw.master;
                break;
            case "graph": sf = R.raw.graph;
                break;
            case "chart": sf = R.raw.chart;
                break;
            case "nasty": sf = R.raw.nasty;
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
            case "plain": sf = R.raw.plain;
                break;
            case "pace": sf = R.raw.pace;
                break;
            case "daily": sf = R.raw.daily;
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
            case "might": sf = R.raw.might;
                break;
            case "timer": sf = R.raw.timer;
                break;
            case "eye": sf = R.raw.eye;
                break;
            case "sight": sf = R.raw.sight;
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
            case "voucher": sf = R.raw.voucher;
                break;
            case "cloud": sf = R.raw.cloud;
                break;
            case "towel": sf = R.raw.towel;
                break;
            case "sound": sf = R.raw.sound;
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
            case "boat": sf = R.raw.boat;
                break;
            case "although": sf = R.raw.although;
                break;
            case "remote": sf = R.raw.remote;
                break;
            case "over": sf = R.raw.over;
                break;
            case "oak": sf = R.raw.oak;
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
            case "really": sf = R.raw.really;
                break;
            case "severe": sf = R.raw.severe;
                break;
            case "clear": sf = R.raw.clear;
                break;
            case "fear": sf = R.raw.fear;
                break;
            case "appear": sf = R.raw.appear;
                break;
            case "rear": sf = R.raw.rear;
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
            case "staircase": sf = R.raw.staircase;
                break;
            case "fair": sf = R.raw.fair;
                break;
            case "bear": sf = R.raw.bear;
                break;
            case "aware": sf = R.raw.aware;
                break;
            case "pair": sf = R.raw.pair;
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
            case "joy": sf = R.raw.joy;
                break;
            case "anmoyed": sf = R.raw.annoyed;
                break;
            case "coil": sf = R.raw.coil;
                break;
            case "appoint": sf = R.raw.appoint;
                break;
            case "soya": sf = R.raw.soya;
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
            case "furious": sf = R.raw.furious;
                break;
            case "alluring": sf = R.raw.alluring;
                break;
            case "tour": sf = R.raw.tour;
                break;
            case "sure": sf = R.raw.sure;
                break;
            case "insurance": sf = R.raw.insurance;
                break;

            // Unstressed i

            case "totally": sf = R.raw.totally;
                break;
            case "usually": sf = R.raw.usually;
                break;
            case "pretty": sf = R.raw.pretty;
                break;
            case "only": sf = R.raw.only;
                break;
            case "funny": sf = R.raw.funny;
                break;

            // TN

            case "rotten": sf = R.raw.rotten;
                break;
            case "bitten": sf = R.raw.bitten;
                break;
            case "written": sf = R.raw.written;
                break;
            case "brighten": sf = R.raw.brighten;
                break;
            case "eaten": sf = R.raw.eaten;
                break;

            // DN

            case "hidden": sf = R.raw.hidden;
                break;
            case "sudden": sf = R.raw.sudden;
                break;
            case "shouldn't": sf = R.raw.shouldnt;
                break;
            case "wouldn't": sf = R.raw.wouldnt;
                break;
            case "hadn't": sf = R.raw.hadnt;
                break;
            case "didn't": sf = R.raw.didnt;
                break;

            // TL

            case "rattle": sf = R.raw.rattle;
                break;
            case "battle": sf = R.raw.battle;
                break;
            case "settle": sf = R.raw.settle;
                break;
            case "cattle": sf = R.raw.cattle;
                break;
            case "kettle": sf = R.raw.kettle;
                break;
            case "subtle": sf = R.raw.subtle;
                break;
            case "nettle": sf = R.raw.nettle;
                break;

            // DL

            case "middle": sf = R.raw.middle;
                break;
            case "saddle": sf = R.raw.saddle;
                break;
            case "cuddle": sf = R.raw.cuddle;
                break;
            case "riddle": sf = R.raw.riddle;
                break;
            case "fiddle": sf = R.raw.fiddle;
                break;
            case "modal": sf = R.raw.modal;
                break;
            case "paddle": sf = R.raw.paddle;
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
            case R.string.desc_connectedspeech: t = "Connected Speech";
                break;
            case R.string.desc_intrusiver: t = "The Intrusive /r/";
                break;
            case R.string.desc_linkingr: t = "The Linking /r/";
                break;
            case R.string.desc_intrusivew: t = "The Intrusive /w/";
                break;
            case R.string.desc_intrusivey: t = "The Intrusive /j/";
                break;
            case R.string.desc_nasalplosions: t = "Nasal Plosion";
                break;
            case R.string.desc_lateralplosions: t = "Lateral Plosion";
                break;
            case R.string.desc_nonrhoticr: t = "The Silent /r/";
                break;
            case R.string.desc_unstressedee: t = "The Unstressed /i/";
                break;
            default: t = "Unknown Title";
                break;
        }

        return t;
    }

    public String[] getWordArr() {
        Intent intent = getIntent();
        String[] fWordArr = intent.getStringArrayExtra("wordArr");
        String[] sWordArr = Arrays.copyOfRange(fWordArr, 0, 5);

        SharedPreferences sp = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), getApplicationContext().MODE_PRIVATE);
        boolean p = sp.getBoolean(getString(R.string.purchased001), false);

        if (!p) {
            return sWordArr;
        } else {
            return fWordArr;
        }
    }

    public boolean ifPurchased() {
        SharedPreferences sp = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), getApplicationContext().MODE_PRIVATE);
        boolean p = sp.getBoolean(getString(R.string.purchased001), false);
        return p;
    }

    @Override
    public void onResume() {
        super.onResume();

        sharedPref = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), getApplicationContext().MODE_PRIVATE);
        purchased001 = sharedPref.getBoolean(getString(R.string.purchased001), false);

        final ViewPager vpPager = (ViewPager) findViewById(R.id.showwordsvpager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        pageSelected = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_words_pager);
        final ViewPager vpPager = (ViewPager) findViewById(R.id.showwordsvpager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        // Shared Preferences

        sharedPref = getApplicationContext().getSharedPreferences(getString(R.string.preference_file_key), getApplicationContext().MODE_PRIVATE);

        // Check if Premium User

        purchased001 = sharedPref.getBoolean(getString(R.string.purchased001), false);

        // Get Intent Stuff

        Intent intent = getIntent();

        String[] wa = getWordArr();

        title = intent.getStringExtra("title");
        sentFrom = intent.getIntExtra("sentFrom", 0);
        moreInfoSections = intent.getIntArrayExtra("moreInfoSections");

        // FIRST TIME

        if (getSoundFile(wa[0]) != 0) {

            if (media != null) {
                media.release();
            }

            media = MediaPlayer.create(getApplicationContext(), getSoundFile(wa[0]));
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
                String[] wa = getWordArr();

                // Make Sound

                if (position < wa.length) { // New implementation because of Promo Fragment

                    if (getSoundFile(wa[position]) != 0) {

                        if (media != null) {
                            media.release();
                        }

                        media = MediaPlayer.create(getApplicationContext(), getSoundFile(wa[position]));
                        media.start();

                        media.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                media.release();
                            }
                        });
                    }
                }

                // Premium Button

                ImageButton star = (ImageButton) findViewById(R.id.premiumbtn);


                    starshowing = false;
                    star.animate().translationX(300);

                    if (!ifPurchased()) {
                        star.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Toast.makeText(ShowWordsPager.this, "This is a premium feature!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        star.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Toast.makeText(ShowWordsPager.this, "This word was unlocked with the premium word pack!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                if (sentFrom != 2) {
                    if (position > 4) {
                        if (!starshowing) {
                            star.setVisibility(View.VISIBLE);
                            //star.setAlpha(0);
                            star.animate().translationX(0);
                        }
                    } else {
                        if (starshowing) {
                            star.animate().translationX(300);
                        }
                    }
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

        // More Info Section

        final LinearLayout moreinfoll = (LinearLayout) findViewById(R.id.moreinfo);

        TextView titleview = (TextView) findViewById(R.id.moreinfotitle);
        titleview.setText(title);

        int insertID = 0;

        // Add Promo Section

        TextView promosub = new TextView(getApplicationContext());
        promosub.setId(0 + 6000);
        promosub.setVisibility(View.GONE);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.topMargin = 24;
        params.bottomMargin = 24;
        moreinfoll.addView(promosub, insertID, params);
        TextView insertedPSub = (TextView) findViewById(0+6000);
        insertedPSub.setText("Go Premium");
        insertedPSub.setTextAppearance(this, R.style.MoreInfoSub);
        insertID++;

        TextView promo = new TextView(getApplicationContext());
        promo.setId(0 + 4000);
        promo.setVisibility(View.GONE);
        LinearLayout.LayoutParams promoparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        promoparams.bottomMargin = 24;
        moreinfoll.addView(promo, insertID, promoparams);
        TextView promobody = (TextView) findViewById(0 + 4000);
        promobody.setText(getString(R.string.promopreview));
        promobody.setTextAppearance(this, R.style.MoreInfoBody);
        insertID++;

        Button promobtn = new Button(getApplicationContext(), null, R.drawable.moreinfobtn);
        promobtn.setId(0 + 5000);
        promobtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.moreinfobtn));
        LinearLayout.LayoutParams promobtnparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        moreinfoll.addView(promobtn, insertID, promobtnparams);
        promobtn = (Button) findViewById(0 + 5000);
        promobtn.setTextSize(16);
        promobtn.setText("UNLOCK PREMIUM");
        promobtn.setVisibility(View.GONE);
        promobtn.setTextColor(getResources().getColor(R.color.colorPrimary));
        insertID++;

        ImageButton moreinfostar = (ImageButton) findViewById(R.id.premiummoreinfobtn);

            moreinfostar.animate().translationX(300);

        moreinfostar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(ShowWordsPager.this, "Descriptions are a premium feature!", Toast.LENGTH_SHORT).show();
            }
        });

        promobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), InAppPurchase.class);
                startActivity(i);
            }
        });

        for (int i = 0; i < moreInfoSections.length; i++) {

            // Subtitle

            TextView subtitle = new TextView(getApplicationContext());
            subtitle.setId(i);
            LinearLayout.LayoutParams subparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            subparams.bottomMargin = 24;
            if (i == 0) {
                subparams.topMargin = 24;
            }
            moreinfoll.addView(subtitle, insertID, subparams);
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
            final int descCount = moreInfoSections.length;
            insertedBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    if (!ifPurchased()) {

                        for (int i = 0; i < descCount; i++) {
                            Button btn = (Button) findViewById(i + 2000);
                            btn.setVisibility(View.GONE);
                        }

                        ImageButton moreinfostar = (ImageButton) findViewById(R.id.premiummoreinfobtn);
                        moreinfostar.setVisibility(View.VISIBLE);
                        moreinfostar.animate().translationX(0);

                        TextView promo = (TextView) findViewById(0 + 4000);
                        promo.setVisibility(View.VISIBLE);
                        promo.setAlpha(0);
                        promo.animate().alpha(1);
                        TextView subtitle = (TextView) findViewById(0 + 6000);
                        subtitle.setVisibility(View.VISIBLE);
                        subtitle.setAlpha(0);
                        subtitle.animate().alpha(1);
                        Button promobtn = (Button) findViewById(0 + 5000);
                        promobtn.setVisibility(View.VISIBLE);
                        promobtn.setAlpha(0);
                        promobtn.animate().alpha(1);
                    } else {

                        Button btn = (Button) findViewById(listenerID + 2000);
                        btn.setVisibility(View.GONE);
                        TextView body = (TextView) findViewById(listenerID + 1000);
                        body.setVisibility(View.VISIBLE);
                        TextView prevbody = (TextView) findViewById(listenerID + 3000);
                        prevbody.setVisibility(View.GONE);
                    }


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

            String[] wa = getWordArr();
            int walength = wa.length;

            if (!ifPurchased()) {
                return walength + 1;
            } else {
                return walength;
            }



        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            String[] wa = getWordArr();

            if (position < wa.length) {
                return ShowWordsFragment.newInstance(title, wa, position);
            } else {
                return PromoFragment.newInstance();
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }

}
