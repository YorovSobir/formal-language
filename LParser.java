// Generated from L.g4 by ANTLR 4.5.3
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
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NEWLINE=1, BOOL=2, IF=3, THEN=4, ELSE=5, WHILE=6, DO=7, READ=8, WRITE=9, 
		BEGIN=10, END=11, COLON=12, SKIP_=13, NUM=14, COMMENT=15, ML_COMMENT=16, 
		IDENT=17, PLUS=18, MINUS=19, MULT=20, DIVIDE=21, MOD=22, POW=23, GT=24, 
		LT=25, GE=26, LE=27, EQ=28, NEQ=29, AND=30, OR=31, ASSIGN=32, LBR=33, 
		RBR=34, NOMATCHED=35;
	public static final int
		RULE_program = 0, RULE_stmt = 1, RULE_write_stmt = 2, RULE_read_stmt = 3, 
		RULE_assign_stmt = 4, RULE_while_stmt = 5, RULE_if_stmt = 6, RULE_exp = 7;
	public static final String[] ruleNames = {
		"program", "stmt", "write_stmt", "read_stmt", "assign_stmt", "while_stmt", 
		"if_stmt", "exp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "'if'", "'then'", "'else'", "'while'", "'do'", "'read'", 
		"'write'", "'begin'", "'end'", "';'", "'skip'", null, null, null, null, 
		"'+'", "'-'", "'*'", "'/'", "'%'", "'**'", "'>'", "'<'", "'>='", "'<='", 
		"'=='", "'!='", "'&&'", "'||'", "':='", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NEWLINE", "BOOL", "IF", "THEN", "ELSE", "WHILE", "DO", "READ", 
		"WRITE", "BEGIN", "END", "COLON", "SKIP_", "NUM", "COMMENT", "ML_COMMENT", 
		"IDENT", "PLUS", "MINUS", "MULT", "DIVIDE", "MOD", "POW", "GT", "LT", 
		"GE", "LE", "EQ", "NEQ", "AND", "OR", "ASSIGN", "LBR", "RBR", "NOMATCHED"
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LVisitor ) return ((LVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			stmt(0);
			setState(17);
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
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public Write_stmtContext write_stmt() {
			return getRuleContext(Write_stmtContext.class,0);
		}
		public Read_stmtContext read_stmt() {
			return getRuleContext(Read_stmtContext.class,0);
		}
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LVisitor ) return ((LVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
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
			setState(26);
			switch (_input.LA(1)) {
			case SKIP_:
				{
				setState(20);
				match(SKIP_);
				}
				break;
			case WHILE:
				{
				setState(21);
				while_stmt();
				}
				break;
			case IF:
				{
				setState(22);
				if_stmt();
				}
				break;
			case WRITE:
				{
				setState(23);
				write_stmt();
				}
				break;
			case READ:
				{
				setState(24);
				read_stmt();
				}
				break;
			case IDENT:
				{
				setState(25);
				assign_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(33);
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
					setState(28);
					if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
					setState(29);
					match(COLON);
					setState(30);
					stmt(7);
					}
					} 
				}
				setState(35);
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

	public static class Write_stmtContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(LParser.WRITE, 0); }
		public TerminalNode LBR() { return getToken(LParser.LBR, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RBR() { return getToken(LParser.RBR, 0); }
		public Write_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LVisitor ) return ((LVisitor<? extends T>)visitor).visitWrite_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Write_stmtContext write_stmt() throws RecognitionException {
		Write_stmtContext _localctx = new Write_stmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_write_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(WRITE);
			setState(37);
			match(LBR);
			setState(38);
			exp(0);
			setState(39);
			match(RBR);
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

	public static class Read_stmtContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(LParser.READ, 0); }
		public TerminalNode LBR() { return getToken(LParser.LBR, 0); }
		public TerminalNode IDENT() { return getToken(LParser.IDENT, 0); }
		public TerminalNode RBR() { return getToken(LParser.RBR, 0); }
		public Read_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LVisitor ) return ((LVisitor<? extends T>)visitor).visitRead_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Read_stmtContext read_stmt() throws RecognitionException {
		Read_stmtContext _localctx = new Read_stmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_read_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(READ);
			setState(42);
			match(LBR);
			setState(43);
			match(IDENT);
			setState(44);
			match(RBR);
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

	public static class Assign_stmtContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(LParser.IDENT, 0); }
		public TerminalNode ASSIGN() { return getToken(LParser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LVisitor ) return ((LVisitor<? extends T>)visitor).visitAssign_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(IDENT);
			setState(47);
			match(ASSIGN);
			setState(48);
			exp(0);
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

	public static class While_stmtContext extends ParserRuleContext {
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
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LVisitor ) return ((LVisitor<? extends T>)visitor).visitWhile_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_while_stmt);
		try {
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(WHILE);
				setState(51);
				match(LBR);
				setState(52);
				exp(0);
				setState(53);
				match(RBR);
				setState(54);
				match(DO);
				setState(55);
				stmt(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(WHILE);
				setState(58);
				match(LBR);
				setState(59);
				exp(0);
				setState(60);
				match(RBR);
				setState(61);
				match(DO);
				setState(62);
				match(BEGIN);
				setState(63);
				stmt(0);
				setState(64);
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

	public static class If_stmtContext extends ParserRuleContext {
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
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LVisitor ) return ((LVisitor<? extends T>)visitor).visitIf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_if_stmt);
		try {
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(IF);
				setState(69);
				match(LBR);
				setState(70);
				exp(0);
				setState(71);
				match(RBR);
				setState(72);
				match(THEN);
				setState(73);
				stmt(0);
				setState(74);
				match(ELSE);
				setState(75);
				stmt(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(IF);
				setState(78);
				match(LBR);
				setState(79);
				exp(0);
				setState(80);
				match(RBR);
				setState(81);
				match(THEN);
				setState(82);
				match(BEGIN);
				setState(83);
				stmt(0);
				setState(84);
				match(END);
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
			case 3:
				enterOuterAlt(_localctx, 3);
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
				stmt(0);
				setState(96);
				match(ELSE);
				setState(97);
				match(BEGIN);
				setState(98);
				stmt(0);
				setState(99);
				match(END);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				match(IF);
				setState(102);
				match(LBR);
				setState(103);
				exp(0);
				setState(104);
				match(RBR);
				setState(105);
				match(THEN);
				setState(106);
				match(BEGIN);
				setState(107);
				stmt(0);
				setState(108);
				match(END);
				setState(109);
				match(ELSE);
				setState(110);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LVisitor ) return ((LVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_exp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			switch (_input.LA(1)) {
			case LBR:
				{
				setState(115);
				match(LBR);
				setState(116);
				exp(0);
				setState(117);
				match(RBR);
				}
				break;
			case BOOL:
				{
				setState(119);
				match(BOOL);
				}
				break;
			case IDENT:
				{
				setState(120);
				match(IDENT);
				}
				break;
			case NUM:
				{
				setState(121);
				match(NUM);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(145);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(124);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(125);
						match(POW);
						setState(126);
						exp(10);
						}
						break;
					case 2:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(127);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(128);
						((ExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MULT) | (1L << DIVIDE) | (1L << MOD))) != 0)) ) {
							((ExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(129);
						exp(10);
						}
						break;
					case 3:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(130);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(131);
						((ExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(132);
						exp(9);
						}
						break;
					case 4:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(133);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(134);
						((ExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << GE) | (1L << LE))) != 0)) ) {
							((ExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(135);
						exp(8);
						}
						break;
					case 5:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(136);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(137);
						((ExpContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQ || _la==NEQ) ) {
							((ExpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(138);
						exp(7);
						}
						break;
					case 6:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(139);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(140);
						((ExpContext)_localctx).op = match(AND);
						setState(141);
						exp(6);
						}
						break;
					case 7:
						{
						_localctx = new ExpContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(142);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(143);
						((ExpContext)_localctx).op = match(OR);
						setState(144);
						exp(5);
						}
						break;
					}
					} 
				}
				setState(149);
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
		case 7:
			return exp_sempred((ExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean stmt_sempred(StmtContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3%\u0099\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3\35\n\3\3\3\3\3\3\3\7\3\"\n\3\f\3\16\3%\13"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7E\n\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bs\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\5\t}\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0094\n\t\f\t\16\t\u0097\13\t\3\t\2\4\4\20"+
		"\n\2\4\6\b\n\f\16\20\2\6\3\2\26\30\3\2\24\25\3\2\32\35\3\2\36\37\u00a4"+
		"\2\22\3\2\2\2\4\34\3\2\2\2\6&\3\2\2\2\b+\3\2\2\2\n\60\3\2\2\2\fD\3\2\2"+
		"\2\16r\3\2\2\2\20|\3\2\2\2\22\23\5\4\3\2\23\24\7\2\2\3\24\3\3\2\2\2\25"+
		"\26\b\3\1\2\26\35\7\17\2\2\27\35\5\f\7\2\30\35\5\16\b\2\31\35\5\6\4\2"+
		"\32\35\5\b\5\2\33\35\5\n\6\2\34\25\3\2\2\2\34\27\3\2\2\2\34\30\3\2\2\2"+
		"\34\31\3\2\2\2\34\32\3\2\2\2\34\33\3\2\2\2\35#\3\2\2\2\36\37\f\b\2\2\37"+
		" \7\16\2\2 \"\5\4\3\t!\36\3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\5\3"+
		"\2\2\2%#\3\2\2\2&\'\7\13\2\2\'(\7#\2\2()\5\20\t\2)*\7$\2\2*\7\3\2\2\2"+
		"+,\7\n\2\2,-\7#\2\2-.\7\23\2\2./\7$\2\2/\t\3\2\2\2\60\61\7\23\2\2\61\62"+
		"\7\"\2\2\62\63\5\20\t\2\63\13\3\2\2\2\64\65\7\b\2\2\65\66\7#\2\2\66\67"+
		"\5\20\t\2\678\7$\2\289\7\t\2\29:\5\4\3\2:E\3\2\2\2;<\7\b\2\2<=\7#\2\2"+
		"=>\5\20\t\2>?\7$\2\2?@\7\t\2\2@A\7\f\2\2AB\5\4\3\2BC\7\r\2\2CE\3\2\2\2"+
		"D\64\3\2\2\2D;\3\2\2\2E\r\3\2\2\2FG\7\5\2\2GH\7#\2\2HI\5\20\t\2IJ\7$\2"+
		"\2JK\7\6\2\2KL\5\4\3\2LM\7\7\2\2MN\5\4\3\2Ns\3\2\2\2OP\7\5\2\2PQ\7#\2"+
		"\2QR\5\20\t\2RS\7$\2\2ST\7\6\2\2TU\7\f\2\2UV\5\4\3\2VW\7\r\2\2WX\7\7\2"+
		"\2XY\7\f\2\2YZ\5\4\3\2Z[\7\r\2\2[s\3\2\2\2\\]\7\5\2\2]^\7#\2\2^_\5\20"+
		"\t\2_`\7$\2\2`a\7\6\2\2ab\5\4\3\2bc\7\7\2\2cd\7\f\2\2de\5\4\3\2ef\7\r"+
		"\2\2fs\3\2\2\2gh\7\5\2\2hi\7#\2\2ij\5\20\t\2jk\7$\2\2kl\7\6\2\2lm\7\f"+
		"\2\2mn\5\4\3\2no\7\r\2\2op\7\7\2\2pq\5\4\3\2qs\3\2\2\2rF\3\2\2\2rO\3\2"+
		"\2\2r\\\3\2\2\2rg\3\2\2\2s\17\3\2\2\2tu\b\t\1\2uv\7#\2\2vw\5\20\t\2wx"+
		"\7$\2\2x}\3\2\2\2y}\7\4\2\2z}\7\23\2\2{}\7\20\2\2|t\3\2\2\2|y\3\2\2\2"+
		"|z\3\2\2\2|{\3\2\2\2}\u0095\3\2\2\2~\177\f\f\2\2\177\u0080\7\31\2\2\u0080"+
		"\u0094\5\20\t\f\u0081\u0082\f\13\2\2\u0082\u0083\t\2\2\2\u0083\u0094\5"+
		"\20\t\f\u0084\u0085\f\n\2\2\u0085\u0086\t\3\2\2\u0086\u0094\5\20\t\13"+
		"\u0087\u0088\f\t\2\2\u0088\u0089\t\4\2\2\u0089\u0094\5\20\t\n\u008a\u008b"+
		"\f\b\2\2\u008b\u008c\t\5\2\2\u008c\u0094\5\20\t\t\u008d\u008e\f\7\2\2"+
		"\u008e\u008f\7 \2\2\u008f\u0094\5\20\t\b\u0090\u0091\f\6\2\2\u0091\u0092"+
		"\7!\2\2\u0092\u0094\5\20\t\7\u0093~\3\2\2\2\u0093\u0081\3\2\2\2\u0093"+
		"\u0084\3\2\2\2\u0093\u0087\3\2\2\2\u0093\u008a\3\2\2\2\u0093\u008d\3\2"+
		"\2\2\u0093\u0090\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\21\3\2\2\2\u0097\u0095\3\2\2\2\t\34#Dr|\u0093\u0095";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}