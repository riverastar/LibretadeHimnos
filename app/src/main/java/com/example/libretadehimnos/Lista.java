package com.example.libretadehimnos;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {
  private ListView lvHimnos;
  private ArrayAdapter<Himno> adapter;
  private ArrayList<Himno> lista;
  private SearchView sI;
  private MediaPlayer mp;
  private Handler handler;
  private SeekBar pista;
  private Runnable runnable;
  private Button play;
  int selecion = 0,selMotor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Codigo para habilitar la flecha atras

        setContentView(R.layout.activity_lista);

        lvHimnos = (ListView) findViewById(R.id.listaHimnos);
        sI = (SearchView) findViewById(R.id.buscar);
        mp = MediaPlayer.create(getApplication(), R.raw.muyprontovendra);
        //pista = (SeekBar) findViewById(R.id.seekBar);
        play = (Button) findViewById(R.id.playMotor);
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        lista = new ArrayList<Himno>();
        //lista de hinmos
        lista.add(new Himno(1,"ANGELES BLANCOS",
                "I"+"\n"+
                "Si yo tuviera de la mañana las raudas alas para volar, yo muy contento me trasladará a las riberas de canaán." +
                "\n"+"Coro"+"\n"+
                "Angeles blancos me llevarían a la presencia de mi señor y yo con júbilo cantaría; con miles de ángeles alrededor." +
                "\n"+"II"+"\n"+
                "Vestidos blancos, palma y corona cada uno de ellos visten allí; y los que ahora que si són fieles, vestidos blancos tendrán también." +
                "\n"+"III"+"\n"+
                "Allí no hay llantos, no hay amargura y no se sabe lo que es dolor, allí és todo paz y alegría, allí es todo paz y amor."));
        lista.add(new Himno(2,"ALLA EN EL CIELO",
                "I"+"\n"+
                "Hay en el cielo un hogar para tí, hay en el cielo un hogar para mí, que cristo tiene y fue a preparar, por ti, por mí, si te decides tendrás ese hogar; porque mi Cristo lo prometió así."+
                "\n"+"Coro"+"\n"+
                "Hace mucho que se fue, viene pronto yo lo sé, a llevarme allá con él y cuando en cielo este mi corona allí tendré. Yo tendré mi corona y tú, no quieres también tener la tuya; si obedeces tendrás con Jesús, la corona de vida segura."+
                "\n"+"II"+"\n"+
                "Oh cuan dulce y gloriosa promesa es vivir con Jesús en el cielo, aunque aquí no he tenido riquezas, seré rico con cristo en los cielos, mi riquezas será vida eterna cuando cristo me tenga en su reino." +
                "\n"+"III"+"\n"+
                "Cristo vino a liberar la batalla, a lucharla a nuestro favor, dejo dicho sigan mis pisadas; que al final tendrán su galardón, en su reino prepara morada para ti, para mí pecador."));
        lista.add(new Himno(3,"CONSEJO DIVINO",
                "I"+"\n"+
                "No vagues por el mundo buscado consolarte, porque seguramente la paz no encontraras, amigo ven a Cristo; él quiere consolarte, él te dará la vida que no se acabará." +
                "\n"+"Coro"+"\n"+
                "Oh señor has tu voluntad quiero yo no ofenderte más." +
                "\n"+"II"+"\n"+
                "La noche esta dormida, el mundo silencioso, la luna y las estrellas; nos brindan claridad, allá en la lejanía vamos a predicar que Cristo es el camino, la vida y la verdad." +
                "\n"+"III"+"\n"+
                "La venida de Cristo, está ya muy cercana, por eso amigo mío no debes de temer. Y nadie está seguro si llegara en la noche, en una mañana o un atardecer." +
                "\n"+"IV"+"\n"+
                "Tampoco estas seguro si tengas larga vida o si el ultimo dia ya muy cercano esta, no sabes si te."));
        lista.add(new Himno(4,"SI ESTAS CUMPLIENDO",
                "I"+"\n"+
                "Si estas cumpliendo un año más de vida, te deseamos que Dios te bendiga (Bis). Que permanezcas muy firme y muy fiel, que no desmayes y tengas valor y que permitas que siempre con él, este tu alma y tu corazón" +
                "\n"+"II"+"\n"+
                "Si estas cumpliendo un año más de vida, te deseamos que Dios te bendiga, que no te falte su gracia y su guía y que adelante con Cristo tu sigas." +
                "\n"+"III"+"\n"+
                "Le pido a Dios que te deje vivir, en este mundo muchos años más, y que la pases siempre muy feliz, que no te falte la dicha y las paz."));
        lista.add(new Himno(5,"QUE EL SEÑOR TE CONCEDA",
                "I"+"\n"+
                "Alabanzas sean dadas al cielo, por los años que vas a cumplir; nos gozamos por tus cumpleaños, porque Dios te dará bendición." +
                "\n"+"II"+"\n"+
                "De los cielos tendrás toda lluvia, abundancia de gozo y de paz. El señor que es la fuente de vida, te bendiga y te guarde en su amor." +
                "\n"+"Coro"+"\n"+
                "Que el señor te conceda en tu vida, serle fiel hasta el día final. Cuando el venga tendrás tu corona que de gloria Jesús te dará."+
                "\n"+"II"+"\n"+
                "Que en el año que empieza tu tengas bendiciones del cielo de verdad, que adelante con Cristo tu sigas hasta el día de la eternidad." +
                "\n"+"III"+"\n"+
                "Cumpleaños feliz, te deseamos a tí, que el señor te bendiga, cumpleaños feliz."));
        lista.add(new Himno(6,"CRISTO HALLOME",
                "I"+"\n"+
                "Cristo hallo me en la miseria y el pecado, lleno estaba el corazón de iniquidad, más Cristo abrió sus brazos y amoroso; guio mis pasos por la senda de la verdad." +
                "\n"+"Coro"+"\n"+
                "Ningún otro me amo, cual Cristo, no hay amigo tan leal y fiel nadie más limpiar pudiera mis pecados, solo Cristo mi buen rey." +
                "\n"+"II"+"\n"+
                "Cada día mi Jesús me da más fuerza hoy, entiendo su lenguaje Arrobador; porque vino del cielo a salvarme, lo sabre tan solo halla en su mansión." +
                "\n"+"III"+"\n"+
                "Yo quisiera hablarles del amor de Cristo; pues en él halle un amigo fuerte y fiel por su gracia transformo mi vida entera, todo lo que soy aquí, lo debo a él."));
        lista.add(new Himno(7,"CUANTO DOLOR",
                "I"+"\n"+
                "Cuanto dolor tu sufriste por mi sobre la cruz del calvario Jesús; por los pecados que yo cometí, llevas mi afrenta y dolorosa." +
                "\n"+"II"+"\n"+
                "Nadie en el mundo podrá comparar el gran amor divino, Jesús vino del cielo para demostrar; que él, de este mundo es la luz." +
                "\n"+"III"+"\n"+
                "Quiero llorar por mis culpas señor; al ver tus manos sangrantes por mí, esa corona de espinas, Oh Dios sobre el excelso Rabí." +
                "\n"+"IV"+"\n"+
                "Mirar tus manos no quiero yo más, porque sangrantes y heridas se ven esas tus manos, tan llenas de paz, claman a Dios tu bien."));
        lista.add(new Himno (8,"DIA TAN GRANDE",
                "I"+"\n"+
                "Día tan grande no puedo olvidar, día de gozo sin par, cuando en tinieblas al verme andar, Cristo me quiso salvar. Gran compasión tuvo Cristo de mí; de gozo y paz me lleno, quito la sombra, me dio plena gloria, la noche en día cambio." +
                "\n"+"Coro"+"\n"+
                "Dios descendio y de gloria me lleno cuando Jesus por gracia me salvo, fui ciego y me hizo ver y por gracia renacer. Dios descendio y de gloria me lleno." +
                "\n"+"II"+"\n"+
                "Nací de nuevo en virtud de Jesús, a la familia de Dios, de las tinieblas pase a la luz, para seguirle en pos, él me prepara un bello rincón, en la mansión celestial, justificado yo siempre alabo su nombre bendito eternal." +
                "\n"+"III"+"\n"+
                "Tengo esperanza de gloria eternal, me regocijo en Jesús, siempre recuerdo con fé y gratitud al contemplarle en la cruz bendito sea, mi Padre y Dios que cuando vine por fé fui adoptado por Cristo el amado, loores por siempre daré."));
        lista.add(new Himno (9,"DAME LA VICTORIA",
                "I"+"\n"+
                "Dame la victoria te lo pido mi señor; dame la victoria, no quiero más dolor, que la paz del cielo me llene al andar y que tu justicia me cubra al caminar." +
                "\n"+"Coro"+"\n"+
                "Dame la victoria en el nombre de Jesús, Dame la victoria, yo quiero ver tu luz y cuando tu vengas en las nubes, te veré y en tu morada siempre estaré." +
                "\n"+"II"+"\n"+
                "Tengo aflicciones que no sé cómo enfrentar, tengo tentaciones que me cuesta superar; pero tú me muestras en tí tengo poder, porque cambias todos los deseos de mi ser."));
        lista.add(new Himno (10,"DIVINO COMPAÑERO",
                "I"+"\n"+
                "Divino compañero de camino; tu presencia siento yo al caminar, pero al verme disipado por las sombras, yo siento luz, la luz divina de tu amor." +
                "\n"+"Coro"+"\n"+
                "Quédate señor que se hace tarde, te ofrezco el corazón para posar, hazlo tu morada permanente, acéptalo, acéptalo, mi salvador." +
                "\n"+"II"+"\n"+
                "Contigo mi jornada se hace corta, habrá luz y el sol no fatigará. En el mar las olas se enfurecen, tu sobre ellas majestuoso andarás." +
                "\n"+"III"+"\n"+
                "La noche se aproxima tenebrosa, y en ella el tentador acechara, no me dejes solo en el camino, ayúdame, ayúdame, hasta llegar."));
        lista.add(new Himno (11,"EN EL SANTUARIO CELESTIAL",
                "I"+"\n"+
                "Hoy me acerco a tu trono mi señor, quiero entrar en el santuario celestial; donde está mi abogado intercesor Jesucristo, que ministra ahí, por mí, que mi oración ascienda ante tu altar como incienso agradable a ti señor, que mi vida entera tu puedas cambiar con la gracia y la justicia de tu amor." +
                "\n"+"Coro"+"\n"+
                "Purifícame con la sangre del cordero redentor, que la paz de Dios llene mi alma entera y mi corazón, Jesucristo mora en mí, quiero hacer tu voluntad." +
                "\n"+"II"+"\n"+
                "En el juicio ante el trono celestial, ya no mires mi pecado, ni mi maldad, solo más a Jesús en mi lugar, que me ayuda en mi gran necesidad, que el perdón que solo tú puedes dar, que me amas y me aceptas como soy, me transforma por la gracia de Jesús, y tu ley en mi vivir puedas guardar."));
        lista.add(new Himno(12,"ESPINAS QUE DAN ROSAS",
                "I"+"\n"+
                "Punzantes los abrojos del camino; nos vienen otra vez a confirmar, indica de este modo al peregrino que el mundo no podrá ser nuestro hogar." +
                "\n"+"Coro"+"\n"+
                "Si en sendas escarpadas tu estas, no temas Dios te ayudara, si el mundo en veces de rosas te da espinas, el señor en rosas de las convertirá." +
                "\n"+"II"+"\n"+
                "En el poder de Dios hay eficiencia para llevar la cruz con humildad, él dice que nos bastara su gloria en la dura y en la cruel adversidad." +
                "\n"+"III"+"\n"+
                "La dura tentación nos aprovecha, nos viene por el cielo a confirmar, quisiera nuestra alma brisa en brecha y triunfante a la cumbre remontar."));
        lista.add(new Himno (13,"FIRME ESTARE",
                "I"+"\n"+
                "Cristo guarda siempre; puedo en él confiar no me deja nunca, puedo en él confiar. Cristo es la roca eterna de los siglos, firme estaré." +
                "\n"+"Coro"+"\n"+
                "Nada no nada me ha de mover (Bis) Cristo es la roca eterna de los siglos, firme estaré. Fuerte Jesucristo puedo en el confiar, todo me ha provisto, puedo en el confiar, Cristo es la roca eterna de los siglos, firme estaré." +
                "\n"+"II"+"\n"+
                "Muchos me abandonan, puedo en el confiar. Otros me engañan, puedo en el confiar. Cristo es la roca eterna de los siglos, firme estaré."));
        lista.add(new Himno (14,"JUVENTUD",
                "I"+"\n"+
                "¡Juventud, juventud! joven pueblo de Dios; el señor te llama hoy a servir, tu belleza, tu fuerza, tu valor quiere el marcharemos animados por doquier." +
                "\n"+"Coro"+"\n"+
                "Jesucristo nuestro jefe, redentor y capitán; va al frente en la lucha no temáis, la victoria ya es nuestra, ¡ved se acerca Canaán!, paso firme pero nunca vaciléis." +
                "\n"+"II"+"\n"+
                "Juventud fortaleza, oye hoy el clamor, de un mundo moribundo de dolor. Marcharemos unidos a la gloria del señor, rescatando almas del fatal error." +
                "\n"+"III"+"\n"+
                "Si hay luchas y fuerzas tu avanza con fé, si Satán intenta todo derrumbar, no olvides Cristo vela y tus pasos siempre ve, gran victoria contra el mal haz de ganar." +
                "\n"+"III"+"\n"+
                "¡Juventud, juventud! pronto vuelve el Señor, proclamad este mensaje sin tardar, consagra tu ser, cuerpo alma y corazón, pon tu vida entera sobre tu altar."));
        lista.add(new Himno(15,"LUZ DE LA MAÑANA",
                "I"+"\n"+
               "Luz de la mañana cual borada bella brilla las estrellas con toda claridad o hermano despierta mira el poema que el Dios infinito otro día nos da." +
                "\n"+"II"+"\n"+
                "Ya cantan las aves trinos de alegría, ya esparcen las flores su aroma sin par murmuran las fuentes todo el santo día y unidos se elevan al Dios celestial."+
                "\n"+"III"+"\n"+
                "Cuando Cristo llame despertar del sueño, venid a mi reino, santos a gozar, surgirán los muertos de gloria cubiertos, los que estén despiertos se transformaran."+
                "\n"+"IV"+"\n"+
                "Entre blancas nubes, nos verán que suben, cuando entre querubines nos podrán mirar o que gran consuelo, ir con él al cielo y estar en su reino por la eternidad."));
        lista.add(new Himno(16,"LA MAÑANA GLORIOSA",
                "I"+"\n"+
                "Cuan gloriosa será la mañana, cuando venga Jesús el salvador, las naciones unidas como hermanas, bienvenida daremos al señor." +
                "\n"+"Coro"+"\n"+
                "No habrá necesidad que la luz el resplandor, ni el sol dará su luz ni tampoco su calor allí llanto no habrá ni tristeza, ni dolor, porque entonces Jesús el rey del cielo para siempre será el consolador." +
                "\n"+"II"+"\n"+
                "Esperemos la mañana gloriosa, para dar la bienvenida al Dios de amor, donde todo será color de rosa, con la santa fragancia del señor." +
                "\n"+"III"+"\n"+
                "El cristiano fiel y verdadero y también el obrero de valor y la iglesia esposa del cordero, estará en los brazos del señor."));
        lista.add(new Himno(17,"LLEVAME SEÑOR",
                "I"+"\n"+
                "Llévame señor a donde vaya, cuídame señor del peligro, líbrame de todo mal, guíame a la salvación." +
                "\n"+"Coro"+"\n"+
                "Llévame, llévame, cuídame, cuídame, líbrame, líbrame, guíame a la salvación." +
                "\n"+"II"+"\n"+
                "Si el señor está conmigo, yo no temo porque él es mi escudo y mi sostén, si estoy en tribulación me sostiene el señor." +
                "\n"+"III"+"\n"+
                "Yo no quiero estar en este mundo, quiero ir a ese bello hogar, la promesa él nos dio y al cielo nos llevara."));
        lista.add(new Himno(18,"MANSION GLORIOSA",
                "I"+"\n"+
                "Mansión gloriosa, hay allá en los cielos, do las maldades; nunca entraran cada tristeza cambiara en consuelo y en dulce canto el dolor y afán." +
                "\n"+"Coro"+"\n"+
                "Bellas mansiones, hay allá en la gloria, tendrá la mía el gozo sin par, suenen las notas de la grata victoria, voy pues con gozo a mi dulce hogar." +
                "\n"+"II"+"\n"+
                "En este mundo predomina el llanto, somos sujetos al dolor fatal, más en el cielo cesará el quebranto y por los siglos nunca habrá más mal." +
                "\n"+"III"+"\n"+
                "Amigo mío cuanto anhelo yo verte libre de pena y de tentación, a Jesucristo debes ya entregarte, tendrás también una bella mansión."));
        lista.add(new Himno(19,"MUY PRONTO VENDRA",
                "I"+"\n"+
                "Muy pronto vendrá, muestro amado y buen salvador. El mundo vera que es un juez y que ya no hay perdón." +
                "\n"+"Coro"+"\n"+
                "Lloraran, Lloraran, lloraran de dolor, lloraran, se lamentarán, los que no siguieron al señor." +
                "\n"+"II"+"\n"+
                "Venid, si venid, dice Cristo al que vagando va, yo te hare vivir, en la patria de la eternidad." +
                "\n"+"III"+"\n"+
                "Mira que el pastor; quiere ovejas para su redil, la puerta el abrió y si quieres hoy puedes seguir."));
        lista.add(new Himno(20,"POR LA MAÑANA",
                "I"+"\n"+
                "Por la mañana yo dirijo mi alabanza, a Dios que ha sido y es mi única esperanza, por la mañana yo le invoco con el alma y le suplico que me dé su dulce calma. El nos escucha pues nos ama tanto y nos alivia de cualquier quebranto, nos da su mano poderosa y fuerte, para aliviarnos de la misma muerte." +
                "\n"+"II"+"\n"+
                "Cuando la noche se aproxima temblorosa, en elevar mi alma se goza siendo su paz, inagotable dulce y grata porque temores y ansias Cristo los mata también, elevo mi cantar al cielo cuando la tierra baja el negro velo, el sol se oculta pero queda Cristo, a quien en un sueño han visto." +
                "\n"+"III"+"\n"+
                "Brilla su lumbre bienhechora mientras duermo, pone su mano sobre mi si estoy enfermo, me fortalece y me alienta, con el sueño pues es mi Dios, mi redentor y él es mi dueño y al despertar por la mañana, siento que Dios invade mi alma y pensamiento veo a Jesús mi redentor amado por mis pecados en la cruz clavo." +
                "\n"+"IV"+"\n"+
                "Veo la sangre de sus manos que han brotado veo la sangre borbollando en su costado una corona de espina en su frente, la multitud escarneciéndole insolente pero que dicha cuando al cielo sube lleno de gloria y majestuosa nube."));
        lista.add(new Himno(21,"SIN MADRE",
                "I"+"\n"+
                "Yo pienso en los niños, que no tienen madre y la tristeza grande que llevan en el alma, quisiera que pudieran en este día de fiesta, sentir lo que yo siento." +
                "\n"+"Coro"+"\n"+
                "Sin madre, sin madre, sin madre, sin madre que triste es vivir (Bis)." +
                "\n"+"II"+"\n"+
                "Que hará me pregunto, un niño sin madre, sin manos que lo alivien, cuando llega la noche, cuando cierran los ojos sin besos en la frente, sin besos de su madre." +
                "\n"+"III"+"\n"+
                "Señor yo te agradezco, porque me has concedido, de tener siempre cerca, a mi madre tan querida, te pido que protejas a tantos niños solos sin el calor de hogar." +
                "\n"+"IV"+"\n"+
                "Mama yo te quiero, tú eres mi gran mundo, con ese amor profundo, yo quiero amarte siempre, tú eres lo más grande, que Dios creo en la tierra nunca me dejes solo."));
        lista.add(new Himno(22,"UN DIA DE BODAS",
                "I"+"\n"+
                "Un día de bodas, el vino falto imposible poderlo comprar, que bello milagro, hiciste señor con el agua de aquel manantial, colmaste hasta el borde del vino mejor, las tinajas que pude llenar. Yo puse mi esfuerzo, yo puse mi afán tú pusiste señor lo demás." +
                "\n"+"Coro"+"\n"+
                "La gente con hambre sentada espero, en el prado que baja hasta el mar, con cuanto tenia a tí se acercó un muchacho que quiso ayudar; su mano en su frente, feliz descanso en sus ojos su dulce mirar. El puso sus peces él puso su pan tú pusiste señor lo demás." +
                "\n"+"II"+"\n"+
                "Los hombres volvieron al amanecer, muy cansados de tanto pescar las barcas vacías, que triste es volver y de nuevo tener que empezar, volvieron al agua a pescar otra vez su palabra les iba a animar, los hombre pusieron la barca y la red tu pusiste señor lo demás." +
                "\n"+"III"+"\n"+
                "Es muy poco señor lo que vengo atraer, es muy poco lo que puedo dar, mi trabajo es el agua que quiero ofrecer y mi esfuerzo un pedazo de pan."));
        lista.add(new Himno(23,"UN DIA COMPRASTES MI ALMA",
                "I"+"\n"+
                "Un día compraste mi alma por eso soy tuyo señor, quitaste el dolor y tristeza, me diste la paz y el perdón." +
                "\n"+"Coro"+"\n"+
                "Yo soy tuyo, muy tuyo señor; no permitas que pierda la fe, el maligno me quiere apartar, pero muy tuyo muy tuyo seré." +
                "\n"+"II"+"\n"+
                "Me diste la paz de la aurora un día su luz me alumbro, en densas tinieblas, me diste la paz y el perdón." +
                "\n"+"III"+"\n"+
                "Un día feliz yo recuerdo cuando de mi sueño salí, dejando este mundo perverso que solo me hizo subir." +
                "\n"+"IV"+"\n"+
                "Escarnio de cruel y inominio sufría mi bendito señor, satán con su furia me sigue, no quiere que sea más de Dios."));
        lista.add(new Himno(24,"YO SOLO ESPERO ESE DIA",
                "I"+"\n"+
                "Yo solo espero ese día, cuando Cristo volverá, yo solo espero ese día, cuando él me llevara, afán y todo trabajo para mi terminará, cuando Cristo venga a su reino me llevará." +
                "\n"+"Coro"+"\n"+
                "Ya no me importa que el mundo me desprecie por doquier, ya no soy más de este mundo, soy del reino celestial. Yo solo espero ese día cuando me levantara de la tumba fría, con un cuerpo ya inmortal." +
                "\n"+"II"+"\n"+
                "Entonces allí triunfante y victorioso cantare a mi señor Jesucristo, cara a cara le veré y ya no habrá más tristeza, ni trabajo para mí, con los redimidos al cordero alabare."));
        lista.add(new Himno(25,"YO QUIERO SER COMO FUE JESUS",
                "I"+"\n"+
                "Yo quiero ser como fue Jesús, Yo quiero ser como fue el señor andando en luz y en santidad y en sus palabras llenas de amor." +
                "\n"+"Coro"+"\n"+
                "Y nos llevará Cristo nos llevará al reino celestial a la bella mansión nunca habrá dolor angustia ni temor si quieres salvación sigamos al señor." +
                "\n"+"II"+"\n"+
                "Sin Cristo yo no podre vivir como el pámpano sin la Vid yo quiero ir donde esta Jesús, yo quiero ir donde está el señor." +
                "\n"+"III"+"\n"+
                "Yo quiero ser como fue Jesús, yo quiero ser como fue el señor, llevando en mí su pesada cruz, en los conflictos y en tentación."));
        lista.add(new Himno(26,"YO SE A QUIEN HE CREIDO",
                "I"+"\n"+
                "No sé porque la gracia del señor me hizo conocer, no sé porque su salvación me dio y salvo soy por él." +
                "\n"+"Coro"+"\n"+
                "Mas yo sé a quién he creído y es poderoso para guardarme y en ese día glorioso iré a morar con él." +
                "\n"+"II"+"\n"+
                "No sé porque el espíritu de Dios convence de pecar, ni se porque revela al pecador cuan negra es la maldad." +
                "\n"+"III"+"\n"+
                "No se la hora en el que el señor vendrá, de día o en oscuridad. Sera en el valle o en el mar, en la que Jesús vendrá."));
        adapter = new ArrayAdapter<Himno>(this,android.R.layout.simple_list_item_1,lista);
        lvHimnos.setAdapter(adapter);
        lvHimnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selecion = (position);
                String titulo = lista.get(position).getHimno();
                String letra = lista.get(position).getLetra();
                //codico para pasar datos a otra actividad
                Intent intent = new Intent(getApplicationContext(),mostrarHimno.class);
                intent.putExtra("titulo",titulo);
                intent.putExtra("letra",letra);
                intent.putExtra("selecion",selecion);
                startActivity(intent);
            }
        });
    }
    //Metodo para mostrar y ocultar el menu y tambien incluye codigo para el motor de busqueda
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, menu);
        final MenuItem searchItem = menu.findItem(R.id.buscar);
        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }
            @Override
            public boolean onQueryTextChange(final String newText) {

                adapter.getFilter().filter(newText);
                lvHimnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //codigo para la opcion buscador
                        String lupa1 = parent.getItemAtPosition(position).toString().substring(3);
                        String lupa2 = parent.getItemAtPosition(position).toString().substring(4);
                        if (lupa1.equals("ANGELES BLANCOS")){
                            selMotor = lista.get(0).getId();
                            String titulo = lista.get(0).getHimno();
                            String letra = lista.get(0).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);

                            startActivity(intent);

                        }
                        if (lupa1.equals("ALLA EN EL CIELO")){
                            selMotor = lista.get(1).getId();
                            String titulo = lista.get(1).getHimno();
                            String letra = lista.get(1).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);

                            startActivity(intent);

                        }
                        if (lupa1.equals("CONSEJO DIVINO")){
                            selMotor = lista.get(2).getId();
                            String titulo = lista.get(2).getHimno();
                            String letra = lista.get(2).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);

                            startActivity(intent);

                        }
                        if (lupa1.equals("SI ESTAS CUMPLIENDO")){
                            selMotor = lista.get(3).getId();
                            String titulo = lista.get(3).getHimno();
                            String letra = lista.get(3).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);

                            startActivity(intent);

                        }
                        if (lupa1.equals("QUE EL SEÑOR TE CONCEDA")){
                            selMotor = lista.get(4).getId();
                            String titulo = lista.get(4).getHimno();
                            String letra = lista.get(4).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);

                            startActivity(intent);

                        }
                        if (lupa1.equals("CRISTO HALLOME")){
                            selMotor = lista.get(5).getId();
                            String titulo = lista.get(5).getHimno();
                            String letra = lista.get(5).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);

                        }
                        if (lupa1.equals("CUANTO DOLOR")){
                            selMotor = lista.get(6).getId();
                            String titulo = lista.get(6).getHimno();
                            String letra = lista.get(6).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);

                        }
                        if (lupa1.equals("DIA TAN GRANDE")){
                            selMotor = lista.get(7).getId();
                            String titulo = lista.get(7).getHimno();
                            String letra = lista.get(7).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);

                        }
                        if (lupa1.equals("DAME LA VICTORIA")){
                            selMotor = lista.get(8).getId();
                            String titulo = lista.get(8).getHimno();
                            String letra = lista.get(8).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);

                        }
                        if (lupa1.equals("DIVINO COMPAÑERO")){
                            selMotor = lista.get(9).getId();
                            String titulo = lista.get(9).getHimno();
                            String letra = lista.get(9).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);

                        }
                        if (lupa2.equals("EN EL SANTUARIO CELESTIAL")){
                            selMotor = lista.get(10).getId();
                            String titulo = lista.get(10).getHimno();
                            String letra = lista.get(10).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);

                        }
                        if (lupa2.equals("ESPINAS QUE DAN ROSAS")){
                            selMotor = lista.get(11).getId();
                            String titulo = lista.get(11).getHimno();
                            String letra = lista.get(11).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);

                        }
                        if (lupa2.equals("FIRME ESTARE")){
                            selMotor = lista.get(12).getId();
                            String titulo = lista.get(12).getHimno();
                            String letra = lista.get(12).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);

                        }
                        if (lupa2.equals("JUVENTUD")){
                            selMotor = lista.get(13).getId();
                            String titulo = lista.get(13).getHimno();
                            String letra = lista.get(13).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("titulo",titulo);
                            intent.putExtra("letra",letra);
                            startActivity(intent);

                        }
                        if (lupa2.equals("LUZ DE LA MAÑANA")){
                            selMotor = lista.get(14).getId();
                            String titulo = lista.get(14).getHimno();
                            String letra = lista.get(14).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("titulo",titulo);
                            intent.putExtra("letra",letra);
                            startActivity(intent);

                        }
                        if (lupa2.equals("LA MAÑANA GLORIOSA")){
                            selMotor = lista.get(15).getId();
                            String titulo = lista.get(15).getHimno();
                            String letra = lista.get(15).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);

                        }
                        if (lupa2.equals("LLEVAME SEÑOR")){
                            selMotor = lista.get(16).getId();
                            String titulo = lista.get(16).getHimno();
                            String letra = lista.get(16).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);

                        }
                        if (lupa2.equals("MASION GLORIOSA")){
                            selMotor = lista.get(17).getId();
                            String titulo = lista.get(17).getHimno();
                            String letra = lista.get(17).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);

                        }
                        if (lupa2.equals("MUY PRONTO VENDRA")){
                            selMotor = lista.get(18).getId();
                            String titulo = lista.get(18).getHimno();
                            String letra = lista.get(18).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);
                            //codigo para el boton pausa y play

                        }
                        if (lupa2.equals("POR LA MAÑANA")){
                            selMotor = lista.get(19).getId();
                            String titulo = lista.get(19).getHimno();
                            String letra = lista.get(19).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);

                        }
                        if (lupa2.equals("SIN MADRE")){
                            selMotor = lista.get(20).getId();
                            String titulo = lista.get(20).getHimno();
                            String letra = lista.get(20).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);

                        }
                        if (lupa2.equals("UN DIA DE BODAS")){
                            selMotor = lista.get(21).getId();
                            String titulo = lista.get(21).getHimno();
                            String letra = lista.get(21).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);

                        }
                        if (lupa2.equals("UN DIA COMPRASTES MI ALMA")){
                            selMotor = lista.get(22).getId();
                            String titulo = lista.get(22).getHimno();
                            String letra = lista.get(22).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);

                        }
                        if (lupa2.equals("YO SOLO ESPERO ESE DIA")){
                            selMotor = lista.get(23).getId();
                            String titulo = lista.get(23).getHimno();
                            String letra = lista.get(23).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);

                        }
                        if (lupa2.equals("YO QUIERO SER COMO FUE JESUS")){
                            selMotor = lista.get(24).getId();
                            String titulo = lista.get(24).getHimno();
                            String letra = lista.get(24).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);

                        }
                        if (lupa2.equals("YO SE A QUIEN HE CREIDO")){
                            selMotor = lista.get(25).getId();
                            String titulo = lista.get(25).getHimno();
                            String letra = lista.get(25).getLetra();
                            Intent intent = new Intent(getApplicationContext(),motordeBusqueda.class);
                            intent.putExtra("mId",selMotor);
                            intent.putExtra("mTitulo",titulo);
                            intent.putExtra("mLetra",letra);
                            startActivity(intent);

                        }
                    }
                });
                return true;
            }
        });
        return true;
    }

}
