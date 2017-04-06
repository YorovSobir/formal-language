// Generated from L.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INTEGER=1, DOUBLE_WITH_INT=2, DOUBLE_WITHOUT_INT=3, DIGIT=4, DIGIT0=5, 
		NUM=6, COMMENT=7, ML_COMMENT=8, IDENT=9, BOOL=10, IF=11, THEN=12, ELSE=13, 
		WHILE=14, DO=15, READ=16, WRITE=17, BEGIN=18, END=19, COLON=20, SKIP_=21, 
		ASSIGN=22, PLUS=23, MINUS=24, MULT=25, DIVIDE=26, MOD=27, POW=28, GT=29, 
		LT=30, GE=31, LE=32, EQ=33, NEQ=34, AND=35, OR=36, LBR=37, RBR=38, NEWLINE=39, 
		NOMATCHED=40;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_while_statement = 2, RULE_if_statement = 3, 
		RULE_exp = 4;
	public static final String[] ruleNames = {
		"program", "stmt", "while_statement", "if_statement", "exp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "'if'", 
		"'then'", "'else'", "'while'", "'do'", "'read'", "'write'", "'begin'", 
		"'end'", "';'", "'skip'", "':='", "'+'", "'-'", "'*'", "'/'", "'%'", "'**'", 
		"'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'&&'", "'||'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INTEGER", "DOUBLE_WITH_INT", "DOUBLE_WITHOUT_INT", "DIGIT", "DIGIT0", 
		"NUM", "COMMENT", "ML_COMMENT", "IDENT", "BOOL", "IF", "THEN", "ELSE", 
		"WHILE", "DO", "READ", "WRITE", "BEGIN", "END", "COLON", "SKIP_", "ASSIGN", 
		"PLUS", "MINUS", "MULT", "DIVIDE", "MOD", "POW", "GT", "LT", "GE", "LE", 
		"EQ", "NEQ", "AND", "OR", "LBR", "RBR", "NEWLINE", "NOMATCHED"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "L.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode EOF() { return getToken(LParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LListener ) ((LListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LListener ) ((LListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10);
			stmt(0);
			setState(11);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public TerminalNode SKIP_() { return getToken(LParser.SKIP_, 0); }
		public TerminalNode IDENT() { return getToken(LParser.IDENT, 0); }
		public TerminalNode ASSIGN() { return getToken(LParser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode WRITE() { return getToken(LParser.WRITE, 0); }
		public TerminalNode LBR() { return getToken(LParser.LBR, 0); }
		public TerminalNode RBR() { return getToken(LParser.RBR, 0); }
		public TerminalNode READ() { return getToken(LParser.READ, 0); }
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode COLON() { return getToken(LParser.COLON, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LListener ) ((LListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LListener ) ((LListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		return stmt(0);
	}

	private StmtContext stmt(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StmtContext _localctx = new StmtContext(_ctx, _parentState);
		StmtContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_stmt, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SKIP_:
				{
				setState(14);
				match(SKIP_);
				}
				break;
			case IDENT:
				{
				setState(15);
				match(IDENT);
				setState(16);
				match(ASSIGN);
				setState(17);
				exp(0);
				}
				break;
			case WRITE:
				{
				setState(18);
				match(WRITE);
				setState(19);
				match(LBR);
				setState(20);
				exp(0);
				setState(21);
				match(RBR);
				}
				break;
			case READ:
				{
				setState(23);
				match(READ);
				setState(24);
				match(LBR);
				setState(25);
				match(IDENT);
				setState(26);
				match(RBR);
				}
				break;
			case WHILE:
				{
				setState(27);
				while_statement();
				}
				break;
			case IF:
				{
				setState(28);
				if_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(36);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StmtContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_stmt);
					setState(31);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(32);
					match(COLON);
					setState(33);
					stmt(6);
					}
					} 
				}
				setState(38);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class While_statementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(LParser.WHILE, 0); }
		public TerminalNode LBR() { return getToken(LParser.LBR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RBR() { return getToken(LParser.RBR, 0); }
		public TerminalNode DO() { return getToken(LParser.DO, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(LParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(LParser.END, 0); }
		public While_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LListener ) ((LListener)listener).enterWhile_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LListener ) ((LListener)listener).exitWhile_statement(this);
		}
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_while_statement);
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				match(WHILE);
				setState(40);
				match(LBR);
				setState(41);
				exp(0);
				setState(42);
				match(RBR);
				setState(43);
				match(DO);
				setState(44);
				stmt(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				match(WHILE);
				setState(47);
				match(LBR);
				setState(48);
				exp(0);
				setState(49);
				match(RBR);
				setState(50);
				match(DO);
				setState(51);
				match(BEGIN);
				setState(52);
				stmt(0);
				setState(53);
				match(END);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(LParser.IF, 0); }
		public TerminalNode LBR() { return getToken(LParser.LBR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RBR() { return getToken(LParser.RBR, 0); }
		public TerminalNode THEN() { return getToken(LParser.THEN, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(LParser.ELSE, 0); }
		public List<TerminalNode> BEGIN() { return getTokens(LParser.BEGIN); }
		public TerminalNode BEGIN(int i) {
			return getToken(LParser.BEGIN, i);
		}
		public List<TerminalNode> END() { return getTokens(LParser.END); }
		public TerminalNode END(int i) {
			return getToken(LParser.END, i);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LListener ) ((LListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LListener ) ((LListener)listener).exitIf_statement(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_if_statement);
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(IF);
				setState(58);
				match(LBR);
				setState(59);
				exp(0);
				setState(60);
				match(RBR);
				setState(61);
				match(THEN);
				setState(62);
				stmt(0);
				setState(63);
				match(ELSE);
				setState(64);
				stmt(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(IF);
				setState(67);
				match(LBR);
				setState(68);
				exp(0);
				setState(69);
				match(RBR);
				setState(70);
				match(THEN);
				setState(71);
				match(BEGIN);
				setState(72);
				stmt(0);
				setState(73);
				match(END);
				setState(74);
				match(ELSE);
				setState(75);
				match(BEGIN);
				setState(76);
				stmt(0);
				setState(77);
				match(END);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				match(IF);
				setState(80);
				match(LBR);
				setState(81);
				exp(0);
				setState(82);
				match(RBR);
				setState(83);
				match(THEN);
				setState(84);
				stmt(0);
				setState(85);
				match(ELSE);
				setState(86);
				match(BEGIN);
				setState(87);
				stmt(0);
				setState(88);
				match(END);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(90);
				match(IF);
				setState(91);
				match(LBR);
				setState(92);
				exp(0);
				setState(93);
				match(RBR);
				setState(94);
				match(THEN);
				setState(95);
				match(BEGIN);
				setState(96);
				stmt(0);
				setState(97);
				match(END);
				setState(98);
				match(ELSE);
				setState(99);
				stmt(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpContext extends ParserRuleContext {
		public Token op;
		public TerminalNode LBR() { return getToken(LParser.LBR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode RBR() { return getToken(LParser.RBR, 0); }
		public TerminalNode BOOL() { return getToken(LParser.BOOL, 0); }
		public TerminalNode IDENT() { return getToken(LParser.IDENT, 0); }
		public TerminalNode NUM() { return getToken(LParser.NUM, 0); }
		public TerminalNode POW() { return getToken(LParser.POW, 0); }
		public TerminalNode MULT() { return getToken(LParser.MULT, 0); }
		public TerminalNode DIVIDE() { return getToken(LParser.DIVIDE, 0); }
		public TerminalNode MOD() { return getToken(LParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(LParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(LParser.MINUS, 0); }
		public TerminalNode GT() { return getToken(LParser.GT, 0); }
		public TerminalNode GE() { return getToken(LParser.GE, 0); }
		public TerminalNode LT() { return getToken(LParser.LT, 0); }
		public TerminalNode LE() { return getToken(LParser.LE, 0); }
		public TerminalNode EQ() { return getToken(LParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(LParser.NEQ, 0); }
		public TerminalNode AND() { return getToken(LParser.AND, 0); }
		public TerminalNode OR() { return getToken(LParser.OR, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LListener ) ((LListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LListener ) ((LListener)listener).exitExp(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBR:
				{
				setState(104);
				match(LBR);
				setState(105);
				exp(0);
				setState(106);
				match(RBR);
				}
				break;
			case BOOL:
				{
				setState(108);
				match(BOOL);
				}
				break;
			case IDENT:
				{
				setState(109);
				match(IDENT);
				}
				break;
			case NUM:
				{
				setState(110);
				match(NUM);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(136);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(134);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(113);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(114);
						match(POW);
						setState(115);
						exp(10);
						}
						break;
					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(116);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(117);
						((ExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIVIDE) | (1L << MOD))) != 0)) ) {
							((ExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(118);
						exp(10);
						}
						break;
					case 3:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(119);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(120);
						((ExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(121);
						exp(9);
						}
						break;
					case 4:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(122);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(123);
						((ExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << GE) | (1L << LE))) != 0)) ) {
							((ExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(124);
						exp(8);
						}
						break;
					case 5:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(125);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(126);
						((ExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((ExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(127);
						exp(7);
						}
						break;
					case 6:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(128);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(129);
						((ExpContext)_localctx).op = match(AND);
						setState(130);
						exp(6);
						}
						break;
					case 7:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(131);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(132);
						((ExpContext)_localctx).op = match(OR);
						setState(133);
						exp(5);
						}
						break;
					}
					} 
				}
				setState(138);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return stmt_sempred((StmtContext)_localctx, predIndex);
		case 4:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean stmt_sempred(StmtContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u008e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3 \n\3\3\3\3\3\3\3\7\3%\n\3\f\3"+
		"\16\3(\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4:\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5h\n\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\5\6r\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0089\n\6\f\6\16"+
		"\6\u008c\13\6\3\6\2\4\4\n\7\2\4\6\b\n\2\6\3\2\33\35\3\2\31\32\3\2\37\""+
		"\3\2#$\2\u009c\2\f\3\2\2\2\4\37\3\2\2\2\69\3\2\2\2\bg\3\2\2\2\nq\3\2\2"+
		"\2\f\r\5\4\3\2\r\16\7\2\2\3\16\3\3\2\2\2\17\20\b\3\1\2\20 \7\27\2\2\21"+
		"\22\7\13\2\2\22\23\7\30\2\2\23 \5\n\6\2\24\25\7\23\2\2\25\26\7\'\2\2\26"+
		"\27\5\n\6\2\27\30\7(\2\2\30 \3\2\2\2\31\32\7\22\2\2\32\33\7\'\2\2\33\34"+
		"\7\13\2\2\34 \7(\2\2\35 \5\6\4\2\36 \5\b\5\2\37\17\3\2\2\2\37\21\3\2\2"+
		"\2\37\24\3\2\2\2\37\31\3\2\2\2\37\35\3\2\2\2\37\36\3\2\2\2 &\3\2\2\2!"+
		"\"\f\7\2\2\"#\7\26\2\2#%\5\4\3\b$!\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2"+
		"\2\2\'\5\3\2\2\2(&\3\2\2\2)*\7\20\2\2*+\7\'\2\2+,\5\n\6\2,-\7(\2\2-.\7"+
		"\21\2\2./\5\4\3\2/:\3\2\2\2\60\61\7\20\2\2\61\62\7\'\2\2\62\63\5\n\6\2"+
		"\63\64\7(\2\2\64\65\7\21\2\2\65\66\7\24\2\2\66\67\5\4\3\2\678\7\25\2\2"+
		"8:\3\2\2\29)\3\2\2\29\60\3\2\2\2:\7\3\2\2\2;<\7\r\2\2<=\7\'\2\2=>\5\n"+
		"\6\2>?\7(\2\2?@\7\16\2\2@A\5\4\3\2AB\7\17\2\2BC\5\4\3\2Ch\3\2\2\2DE\7"+
		"\r\2\2EF\7\'\2\2FG\5\n\6\2GH\7(\2\2HI\7\16\2\2IJ\7\24\2\2JK\5\4\3\2KL"+
		"\7\25\2\2LM\7\17\2\2MN\7\24\2\2NO\5\4\3\2OP\7\25\2\2Ph\3\2\2\2QR\7\r\2"+
		"\2RS\7\'\2\2ST\5\n\6\2TU\7(\2\2UV\7\16\2\2VW\5\4\3\2WX\7\17\2\2XY\7\24"+
		"\2\2YZ\5\4\3\2Z[\7\25\2\2[h\3\2\2\2\\]\7\r\2\2]^\7\'\2\2^_\5\n\6\2_`\7"+
		"(\2\2`a\7\16\2\2ab\7\24\2\2bc\5\4\3\2cd\7\25\2\2de\7\17\2\2ef\5\4\3\2"+
		"fh\3\2\2\2g;\3\2\2\2gD\3\2\2\2gQ\3\2\2\2g\\\3\2\2\2h\t\3\2\2\2ij\b\6\1"+
		"\2jk\7\'\2\2kl\5\n\6\2lm\7(\2\2mr\3\2\2\2nr\7\f\2\2or\7\13\2\2pr\7\b\2"+
		"\2qi\3\2\2\2qn\3\2\2\2qo\3\2\2\2qp\3\2\2\2r\u008a\3\2\2\2st\f\f\2\2tu"+
		"\7\36\2\2u\u0089\5\n\6\fvw\f\13\2\2wx\t\2\2\2x\u0089\5\n\6\fyz\f\n\2\2"+
		"z{\t\3\2\2{\u0089\5\n\6\13|}\f\t\2\2}~\t\4\2\2~\u0089\5\n\6\n\177\u0080"+
		"\f\b\2\2\u0080\u0081\t\5\2\2\u0081\u0089\5\n\6\t\u0082\u0083\f\7\2\2\u0083"+
		"\u0084\7%\2\2\u0084\u0089\5\n\6\b\u0085\u0086\f\6\2\2\u0086\u0087\7&\2"+
		"\2\u0087\u0089\5\n\6\7\u0088s\3\2\2\2\u0088v\3\2\2\2\u0088y\3\2\2\2\u0088"+
		"|\3\2\2\2\u0088\177\3\2\2\2\u0088\u0082\3\2\2\2\u0088\u0085\3\2\2\2\u0089"+
		"\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\13\3\2\2"+
		"\2\u008c\u008a\3\2\2\2\t\37&9gq\u0088\u008a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}