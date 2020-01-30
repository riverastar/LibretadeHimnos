package com.example.libretadehimnos;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {
  private ListView lvHimnos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Codigo para habilitar la flecha de atras
        Bundle bundle = getIntent().getExtras();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_lista);

        lvHimnos = (ListView) findViewById(R.id.listaHimnos);

        final ArrayList<Himno> lista = new ArrayList<Himno>();
        lista.add(new Himno(1,"ANGELES BLANCOS",
                "Si yo tuviera de la mañana las raudas alas para volar yo muy contento me trasladara a las riberas de canaan." +
                "\n"+"\n"+"Coro"+"\n"+"\n"+
                "Angeles blancos me llevarian a la presencia de mi señor y yo con jubilo cantaria con miles de angeles alrededor." +
                "\n"+"\n"+
                "Vestidos blancos palma y corona cada uno de ellos visten alli y los que ahora que si son fieles vestidos blancos tendran tambien." +
                "\n"+"\n"+
                "Alli no hay llantos no hay amargura y no se sabe lo que es dolor, alli es todo paz y alegria alli es todo paz y amor."));
        lista.add(new Himno(2,"CONSEJO DIVINO",
                "No vagues por el mundo buscado consolarte porque seguramente la paz no encontraras, amigo ven a cristo el quiere consolarte, el te dara la vida que no se acabara." +
                "\n"+"\n"+"Coro"+"\n"+"\n"+
                "Oh señor has tu voluntad quiero yo no ofenderte mas."+"\n"+"\n"+
                "La noche esta dormida el mundo silencioso la luna y las estrellas nos brindan claridad, alla en la lejania vamos a predicar que cristo es el camino la vida y la verdad." +
                "\n"+"\n"+"La venida de cristo esta ya muy cercana por eso amigo mio no debes de temer y nadien esta seguro si llegara en la noche en una mañana o un atardecer." +
                "\n"+"\n"+"Tampoco estas seguro si tengas larga vida o si el ultimo dia ya muy cercano esta, no sabes si te"));
        lista.add(new Himno(3,"CUMPLEAÑOS",
                "Si estas cumpliendo un año mas de vida te deseamos que Dios te bendiga(Bis). Que permanezcas muy firme y muy fiel, que no desmayes y tengas valor y que permitas que siempre con el, este tu alma y tu corazon." +
                "\n"+"\n"+
                "Si estas cumpliendo un año mas de vida te deseamos que Dios te bendiga que no te falte su gracia y su guia y que adelante con cristo tu sigas." +
                "\n"+"\n"+
                "Le pido a Dios que te deje vivir en este mundo muchos años mas y que la pases siempre muy feliz, que te falte la dicha y las paz."));
        lista.add(new Himno(4,"CUMPLEAÑOS 2",
                "Alabanzas sean dadas al cielo por los años que vas a cumplir nos gozamos por tus cumpleaños porque Dios te dara bendicion." +
                "\n"+"\n"+
                "De los cielos tendras toda lluvia abundancia de gozo y de paz el señor que es la fuente de vida te bendiga y te guarde en su amor." +
                "\n"+"\n"+"Coro"+"\n"+"\n"+
                "Que el señor te conceda en tu vida serle fiel hasta el dia final. Cuando el venga tendras tu corona que de gloria Jesus te dara."+
                "\n"+"\n"+
                "Que en el año que empieza tu tengas bendiciones del cielo de verdad, que adelante con Cristo tu sigas hasta el dia de la eternidad." +
                "\n"+"\n"+
                "Cumpleaños feliz te deseamos a ti que el señor te bendiga, Cumpleaños feliz."));
        lista.add(new Himno(5,"CRISTO HALLOME",
                "Cristo hallome en la miseria y el pecado, lleno estaba el corazon de iniquidad, mas Cristo abrio sus brazos y amoroso guio mis pasos por la senda de la verdad." +
                "\n"+"\n"+"Coro"+"\n"+"\n"+
                "Ningun otro me amo cual Cristo no hay amigo tan leal y fiel nadie mas limpiar pudiera mis pecados solo Cristo mi buen rey." +
                "\n"+"\n"+
                "Cada dia mi Jesus me da mas fuerza hoy entiendo su lenguaje Arrobador porque vino del cielo a salvarme lo sabre tan solo halla en su mansion." +
                "\n"+"\n"+
                "Yo quisiera hablarles del amor de Cristo pues en el halle un amigo fuerte y fiel por su gracia transformo mi vida entera todo lo que soy aqui, lo debo a él."));
        lista.add(new Himno(6,"CUANTO DOLOR",
                "Cuanto dolor tu sufriste por mi sobre la cruz del calvario Jesus, por los pecados que yo cometi llevas mi afrenta y dolorosa." +
                "\n"+"\n"+
                "Nadien en el mundo podra comparar el gran amor divino, Jesus vino del cielo para demostrar que el de este mundo es la luz." +
                "\n"+"\n"+
                "Quiero llorar por mis culpas señor, al ver tus manos sangrantes por mi esa corona de espinas, Oh Dios sobre el excelso Rabbi." +
                "\n"+"\n"+
                "Mirar tus manos no quiero yo mas porque sangrantes y heridas se ven esas tus manos tan llenas de paz claman a Dios tu bien."));
        lista.add(new Himno (7,"DIA TAN GRANDE",
                "Dia tan grande no puedo olvidar, dia de gozo sin par cuando en tinieblas al verme andar, Cristo me quizo salvar. Gran compacion tuvo Cristo de mi, de gozo y paz me lleno, quito la sombra me dio plena gloria, la noche en dia cambio." +
                "\n"+"\n"+"Coro"+"\n"+"\n"+
                "Dios descendio y de gloria me lleno cuando Jesus por gracia me salvo, fui ciego y me hizo ver y por gracia renacer. Dios descendio y de gloria me lleno." +
                "\n"+"\n"+
                "Naci de nuevo en virtud de Jesus, a la familia de Dios de las tinieblas pase a la luz para seguirle en pos, el me prepara un bello rincon en la mansion celestial, justificado yo siempre alabo su nombre bendito eternal." +
                "\n"+"\n"+
                "Tengo esperanza de gloria eternal, me regocijo en Jesus siempre recuerdo con fe y gratitud al contemplarle en la cruz bendito sea, mi Padre y Dios que cuando vine por fé fui adoptado por Cristo el amado loores por siempre dare."));
        lista.add(new Himno (8,"DAME LA VICTORIA",
                "Dame la victoria te lo pido mi señor, dame la victoria no quiero mas dolor que la paz del cielo me llene al andar y que tu justicia me cubra al caminar." +
                "\n"+"\n"+"Coro"+"\n"+"\n"+
                "Dame la victoria en el nombre de Jesus, Dame la victoria yo quiero ver tu luz y cuando tu vengas en las nubes, te vere y en tu morada siempre estare." +
                "\n"+"\n"+
                "Tengo aflicciones que no se como enfrentar, tengo tentaciones que me cuesta superar pero tu me muestras en ti tengo poder porque cambias todos los deseos de mi ser."));
        lista.add(new Himno (9,"DIVINO COMPAÑERO",
                "Divino compañero de camino tu presencia siento yo al caminar pero al verme disipado por las sombras yo siento luz, la luz divina de tu amor." +
                "\n"+"\n"+"Coro"+"\n"+"\n"+
                "Quedate señor que se hace tarde te obrezco el corazon para posar hazlo tu morada permanente aceptalo, aceptalo nuevamente mi salvardor." +
                "\n"+"\n"+
                "Contigo mi jornada se hace corta habra luz y el sol no fatigara en el mar las olas se enfurecen tu sobre ellas majestuoso andaras." +
                "\n"+"\n"+
                "La noche se aproxima tenebrosa y en ella el tentador acechara no me dejes solo en el camino ayudame, ayudame hasta llegar."));
        lista.add(new Himno (10,"EN EL SANTUARIO CELESTIAL",
                "Hoy me acerco a tu trono mi señor quiero entrar en el santuario celestial donde esta mi abogado, intercesor, Jesucristo que ministra hay por mi que mi oracion ascienda ante tu altar como incienso agradable a ti señor que mi vida entera tu puedas cambiar con la gracia y la justicia de tu amor." +
                "\n"+"\n"+"Coro"+"\n"+"\n"+
                "Purificame con la sangre del cordero redentor que la paz de Dios llene mi alma entera y mi corazon, Jesucristo mora en mi, quiero hacer tu voluntad." +
                "\n"+"\n"+
                "En el juicio ante el trono celestial ya no mires mi pecado ni mi maldad, solo mas a Jesus en mi lugar que me ayuda en mi gran necesidad que el perdon que solo tu puedes dar que me amas y me aceptas como soy me transforma por la gracia de Jesus y tu ley en mi vivir puedas guardar."));
        lista.add(new Himno (11,"FIRME ESTARE",
                "Cristo guarda siempre, puedo en el confiar no me deja nunca puedo en el confiar. Cristo es la roca eterna de los siglos, firme estare." +
                "\n"+"\n"+"Coro"+"\n"+"\n"+
                "Nada no nada me ha de mover(Bis) Cristo es la roca eterna de los siglos, firme estare. Fuerte Jesucristo puedo en el confiar, todo me ha provisto, puedo en el confiar, Cristo es la roca eterna de los siglos, firme estare." +
                "\n"+"\n"+
                "Muchos me abandonan, puedo en el confiar. Otros me engañan, puedo en el confiar. Cristo es la roca eterna de los siglos, firme estare."));
        lista.add(new Himno (12,"JUVENTUD",
                "Juventud, juventud joven pueblo de Dios, el señor te llama hoy a servir, tu belleza, tu fuerza, tu valor quiere el marcharemos animados por doquier." +
                "\n"+"\n"+"Coro"+"\n"+"\n"+
                "Cristo nuestro jefe redentor y capitan va al frente en la lucha no temais, la victoria ya es nuestra ved se acerca Canaan, paso firme pero nunca vacileis." +
                "\n"+"\n"+
                "Juventud fortaleza, Oye hoy el clamor de un mundo moribundo de dolor marcharemos unidos a la gloria del señor rescatando almas del fatal error." +
                "\n"+"\n"+
                "Si hay luchas y fuerzas tu avanza con fe, si Satan intenta todo terrimbar no olvidez Cristo vela y tus pasos siempre ve, gran victoria contra el mal haz de ganar." +
                "\n"+"\n"+
                "Juventud, juventud pronto vuelve el Señor proclamad este mensaje sin tardar consagra tu ser cuerpo alma y corazon pon tu vida entera sobre tu altar."));
        lista.add(new Himno(13,"LUZ DE LA MAÑANA",
               "Luz de la mañana cual borada bella brilla las estrellas con toda claridad o hermano despierta mira el poema que el Dios infinito otro dia nos da." +
                "\n"+"\n"+
                "Ya cantan las aves trinos de alegria, ya esparcen las flores su aroma sin par murmuran las fuentes todo el santo dia y unidos se elevan al Dios celestial."+
                "\n"+"\n"+
                "Cuando Cristo llame despertar del sueño, venid a mi reino santos a gozar surgiran los muertos de gloria cubiertos los que esten despiertos se transformaran."+
                "\n"+"\n"+
                "Entre blancas nubes nos veran que suben cuando entre querubines nos podran mirar o que gran consuelo ir con el al cielo y estar en su reino por la eternidad."));
        lista.add(new Himno(14,"LA MAÑANA GLORIOSA",
                "Cuan gloriosa sera la mañana, cuando venga Jesus el salvador las naciones unidas como hermanas bienvenida daremos al señor." +
                "\n"+"\n"+"Coro"+"\n"+"\n"+
                "No habra necesidad que la luz el resplandor, ni el sol dara su luz ni tampoco su calor alli llanto no habra ni tristeza, ni dolor, porque entonces Jesus el rey del cielo para siempre sera el consolador." +
                "\n"+"\n"+
                "Esperemos la mañana gloriosa para dar la bienvenida al Dios de amor donde todo sera color de rosa con la santa fragancia del señor." +
                "\n"+"\n"+
                "El cristiano fiel y verdadero y tambien el obrero de valor y la iglesia esposa del cordero estara en los brazos del señor."));
        lista.add(new Himno(15,"LLEVAME SEÑOR",
                "Llevame señor a donde vaya cuidame señor del peligro librame de todo mal guiame a la salvacion." +
                "\n"+"\n"+"Coro"+"\n"+"\n"+
                "Llevame llevame cuidame cuidame librame librame guiame a la salvacion." +
                "\n"+"\n"+
                "Si el señor esta conmigo yo no temo porque el es mi escudo y mi sosten si estoy en tribulacion me sostiene el señor." +
                "\n"+"\n"+
                "Yo no quiero estar en este mundo quiero ir a ese bello hogar la pormesa el nos dio y al cielo nos llevara."));
        lista.add(new Himno(16,"MANSION GLORIOSA",
                "Mansion gloriosa hay alla en los cielos do las maldades nunca entraran cada tristeza cambiara en consuelo y en dulce canto el dolor y afan." +
                "\n"+"\n"+"Coro"+"\n"+"\n"+
                "Bellaz mansiones alla en la gloria tendra la mia el gozo sin par suenen las notas de la grata victoria voy pues con gozo a mi dulce hogar." +
                "\n"+"\n"+
                "En este mundo predomina el llanto somos sujetos al dolor fatal mas en el cielo cesara el quebranto y por los siglos nunca habra mas mal." +
                "\n"+"\n"+
                "Amigo mio cuanto anehelo yo verte libre de pena y de tentacion a Jesucristo debes ya entregarte, tendras tambien una bella mansion."));
        lista.add(new Himno(17,"ESPINA QUE DAN ROSAS",
                "Punsantez los abrogos del camino nos vienen otra vez a confirmar indica de este modo al peregrino que el mundo no podra ser nuestro hogar." +
                "\n"+"\n"+"Coro"+"\n"+"\n"+
                "Si en sendas escarpadas tu estas no temas Dios te ayudara, si el munod en veces de rosas te da espinaz el señor en rosas de las convertira." +
                "\n"+"\n"+
                "En el poder de Dios hay eficiencia para llevar la cruz con humildad el dice que nos bastara su gloria en la dura y en la cruel adversidad." +
                "\n"+"\n"+
                "La dura tentacion nos aprovecha nos viene por el cielo a confirmar quisiera nuestra alma brisa en brecha y triunfante a la cumbre remontar."));
        lista.add(new Himno(18,"MUY PRONTO VENDRA",
                "Muy pronto vendra muestro amado y buen salvador el mundo vera que es un juez y que ya no hay perdon." +
                "\n"+"\n"+"Coro"+"\n"+"\n"+
                "Lloraran, Lloraran, lloraran de dolor, lloraran, se lamentaran los que no siguieron al señor." +
                "\n"+"\n"+
                "Venid, si venid, dice Cristo al que bajando va, yo te hara vivir en la patria de la eternidad." +
                "\n"+"\n"+
                "Mira que el pastor quiere ovejas para su redil la puerta el abre y si quieres hoy puedes seguir."));
        lista.add(new Himno(19,"YO SOLO ESPERO ESE DIA",
                "Yo solo espero ese dia cuando Cristo volvera, yo solo espero ese dia cuando el me llevara, afan y todo trabajo para mi terminara cuando Cristo venga a su reino me llevara." +
                "\n"+"\n"+"Coro"+"\n"+"\n"+
                "Ya no me importa que el mundo me desprecie por doquier ya no soy mas de este mundo, soy del reino celestial. Yo solo espero ese dia cuando me levantara de la tumba fria con un cuerpo ya inmortal." +
                "\n"+"\n"+
                "Entonces alli triunfante y victorioso cantare a mi señor Jesucirsto cara a cara le vere y ya no habra mas tristeza ni trabajo para mi, con los redimidos al cordero alabare."));
        lista.add(new Himno(20,"YO QUIERO SER COMO FUE JESUS",
                "Yo quiero ser como fue Jesus, Yo quiero ser como fue el señor andando en luz y en santidad y en sus palabras llenas de amor." +
                "\n"+"\n"+"Coro"+"\n"+"\n"+
                "Y nos llevara Cristo nos llevara al reino celestial a la bella mansion nunca habra dolor angustia ni temor si quieres salvacion sigamos al señor." +
                "\n"+"\n"+
                "Sin Cristo yo no podre vivir como el panpano sin la Vid yo quiero ir donde esta Jesus, yo quiero ir donde esta el señor." +
                "\n"+"\n"+
                "Yo quiero ser como fue Jesus, yo quiero ser como fue el señor, llevando en mi su pesada cruz, en los conflictos y en tentacion."));
        lista.add(new Himno(21,"ALLA EN EL CIELO",
                ""));




        ArrayAdapter <Himno> adaptador = new ArrayAdapter<Himno>(this,android.R.layout.simple_list_item_1,lista);
        lvHimnos.setAdapter(adaptador);

        lvHimnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int selecion = (position);
                String titulo = lista.get(position).getHimno();
                String letra = lista.get(position).getLetra();

                Intent intent = new Intent(getApplicationContext(),mostrarHimno.class);

                intent.putExtra("titulo",titulo);
                intent.putExtra("letra",letra);
                intent.putExtra("selecion",selecion);
                startActivity(intent);


            }
        });
    }

}
