public class Main {
    public static void main(String[] args) {

        CaesarCipher c = new CaesarCipher();
        //key = 7 (a -> h)
        String decoded = c.caesarDecoder("Pu jyfwavnyhwof, h Jhlzhy jpwoly, hszv ruvdu hz Jhlzhy'z jpwoly, aol zopma jpwoly, " +
                "Jhlzhy'z jvkl vy Jhlzhy zopma, pz vul vm aol zptwslza huk tvza dpklsf ruvdu lujyfwapvu aljoupxblz. Pa pz h afwl " +
                "vm zbizapabapvu jpwoly pu dopjo lhjo slaaly pu aol wshpualea pz ylwshjlk if h slaaly zvtl mpelk ubtily vm wvzpapvuz " +
                "kvdu aol hswohila. Mvy lehtwsl, dpao h slma zopma vm 3, K dvbsk il ylwshjlk if H, L dvbsk iljvtl I, huk zv vu. " +
                "Aol tlaovk pz uhtlk hmaly Qbspbz Jhlzhy, dov bzlk pa pu opz wypchal jvyylzwvuklujl. Aol lujyfwapvu zalw wlymvytlk " +
                "if h Jhlzhy jpwoly pz vmalu pujvywvyhalk hz whya vm tvyl jvtwsle zjoltlz, zbjo hz aol Cpnluèyl jpwoly, huk zapss " +
                "ohz tvklyu hwwspjhapvu pu aol YVA13 zfzalt. Hz dpao hss zpunsl-hswohila zbizapabapvu jpwolyz, aol Jhlzhy jpwoly pz " +
                "lhzpsf iyvrlu huk pu tvklyu wyhjapjl vmmlyz lzzluaphssf uv jvttbupjhapvuz zljbypaf.");
        System.out.println("Testing CaesarCipher:");
        System.out.println(decoded);

        VigenèreCipher v = new VigenèreCipher();
        //key = cry
        decoded = v.VigenèreDecoder("Ke atpnvfetrnjp, y Ercurp eznjvp, ccqq blqnl cj Acvqci'q eznjvp, vyc uyghk akgfgi, " +
                "Acvqci'q efbg fp Ercurp uyghk, gu flg fd vyc uzkrccuk ypu kqjr yzbgcw memye cptpagrkfl vvajegslcu. Zr kj y vpng " +
                "fd ulzukgvlrkfl eznjvp ke ujzaj vyey jgkrgi gp kfg gjczlvvvv zq tvnnragu za r jgkrgi qqdc hzvgu lwdzgi mh gmuzrkflu " +
                "umye rjv yngfcscv. Wmt vvcdnnv, ukkf c cchk qjzdv fd 3, F nmwcb dv pggjctcf sw C, V uqljf scefkg S, ypu qq fl. " +
                "Vyc ovrjfb kj lcdcf rdvvp Lljklq Ercurp, yym wjcf zr ke fkj ntztckc efptvqrflfvlev. Rjv cptpagrkfl ukcr gctwmtdcf sw " +
                "c Tygjyt tgryct zq qwrge gptmtgmtrrgu yu gytk mh dmtv aqdnnvv utfgdcu, jsey yu kfg Mgivlgic eznjvp, ceb ukgnc fcj " +
                "kqucte yrgjktyvzmp zl vyc TFR13 upqvvk. Cj ukkf ccj uzlicc-ccnjrzgk qwsqvzrwkgqe akgfgiq, vyc Ercurp eznjvp kj " +
                "ccjgnp ztfige ypu gp dmfvpp gpctrktc qwdgiq gjqgerkrjnp lq tmodspzackgqeq uvawigvp.");
        System.out.println("Testing Vigenère Cipher:");
        System.out.println(decoded);
    }
}
