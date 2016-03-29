// This is a generated file. Not intended for manual editing.
package com.dyrkin.monkeyc.idea.plugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.dyrkin.monkeyc.idea.plugin.psi.MonkeyTypes.*;
import static com.dyrkin.monkeyc.idea.plugin.parser.MonkeyParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MonkeyParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == ADDITIVE_EXPRESSION) {
      r = additiveExpression(b, 0);
    }
    else if (t == AND_EXPRESSION) {
      r = andExpression(b, 0);
    }
    else if (t == ANNOTATION) {
      r = annotation(b, 0);
    }
    else if (t == ARGUMENTS) {
      r = arguments(b, 0);
    }
    else if (t == ARRAY_CREATOR) {
      r = arrayCreator(b, 0);
    }
    else if (t == ARRAY_INITIALIZER) {
      r = arrayInitializer(b, 0);
    }
    else if (t == ASSIGNMENT_OPERATOR) {
      r = assignmentOperator(b, 0);
    }
    else if (t == BITWISE_EXPRESSION) {
      r = bitwiseExpression(b, 0);
    }
    else if (t == BITWISE_OPERATOR) {
      r = bitwiseOperator(b, 0);
    }
    else if (t == BLOCK) {
      r = block(b, 0);
    }
    else if (t == BLOCK_STATEMENT) {
      r = blockStatement(b, 0);
    }
    else if (t == CATCH_CLAUSE) {
      r = catchClause(b, 0);
    }
    else if (t == CATCH_PARAMETER) {
      r = catchParameter(b, 0);
    }
    else if (t == CATCHES) {
      r = catches(b, 0);
    }
    else if (t == CLASS_BODY) {
      r = classBody(b, 0);
    }
    else if (t == CLASS_BODY_DECLARATION) {
      r = classBodyDeclaration(b, 0);
    }
    else if (t == CLASS_CREATOR_REST) {
      r = classCreatorRest(b, 0);
    }
    else if (t == CLASS_DECLARATION) {
      r = classDeclaration(b, 0);
    }
    else if (t == CLASS_NAME) {
      r = className(b, 0);
    }
    else if (t == COMPONENT_NAME) {
      r = componentName(b, 0);
    }
    else if (t == CONDITIONAL_AND_EXPRESSION) {
      r = conditionalAndExpression(b, 0);
    }
    else if (t == CONDITIONAL_EXPRESSION) {
      r = conditionalExpression(b, 0);
    }
    else if (t == CONDITIONAL_OR_EXPRESSION) {
      r = conditionalOrExpression(b, 0);
    }
    else if (t == CONST_DECLARATION) {
      r = constDeclaration(b, 0);
    }
    else if (t == CREATOR) {
      r = creator(b, 0);
    }
    else if (t == DICTIONARY_CREATOR) {
      r = dictionaryCreator(b, 0);
    }
    else if (t == ENUM_BODY) {
      r = enumBody(b, 0);
    }
    else if (t == ENUM_BODY_DECLARATIONS) {
      r = enumBodyDeclarations(b, 0);
    }
    else if (t == ENUM_CONSTANT) {
      r = enumConstant(b, 0);
    }
    else if (t == ENUM_CONSTANTS) {
      r = enumConstants(b, 0);
    }
    else if (t == EQUALITY_EXPRESSION) {
      r = equalityExpression(b, 0);
    }
    else if (t == EXCLUSIVE_OR_EXPRESSION) {
      r = exclusiveOrExpression(b, 0);
    }
    else if (t == EXPLICIT_CONSTRUCTOR_INVOCATION) {
      r = explicitConstructorInvocation(b, 0);
    }
    else if (t == EXPRESSION) {
      r = expression(b, 0);
    }
    else if (t == EXPRESSION_LIST) {
      r = expressionList(b, 0);
    }
    else if (t == FIELD_DECLARATION) {
      r = fieldDeclaration(b, 0);
    }
    else if (t == FOR_INIT) {
      r = forInit(b, 0);
    }
    else if (t == FOR_STATEMENT) {
      r = forStatement(b, 0);
    }
    else if (t == FORMAL_PARAMETER_DECLS) {
      r = formalParameterDecls(b, 0);
    }
    else if (t == FORMAL_PARAMETERS) {
      r = formalParameters(b, 0);
    }
    else if (t == FUNCTION_DECLARATION) {
      r = functionDeclaration(b, 0);
    }
    else if (t == HAS_EXPRESSION) {
      r = hasExpression(b, 0);
    }
    else if (t == ID) {
      r = id(b, 0);
    }
    else if (t == IDENTIFIER_SUFFIX) {
      r = identifierSuffix(b, 0);
    }
    else if (t == INCLUSIVE_OR_EXPRESSION) {
      r = inclusiveOrExpression(b, 0);
    }
    else if (t == INSTANCE_OF_EXPRESSION) {
      r = instanceOfExpression(b, 0);
    }
    else if (t == KEY_VALUE_INITIALIZER) {
      r = keyValueInitializer(b, 0);
    }
    else if (t == LITERAL) {
      r = literal(b, 0);
    }
    else if (t == LOCAL_VARIABLE_DECLARATION) {
      r = localVariableDeclaration(b, 0);
    }
    else if (t == LOCAL_VARIABLE_DECLARATION_STATEMENT) {
      r = localVariableDeclarationStatement(b, 0);
    }
    else if (t == MODIFIERS) {
      r = modifiers(b, 0);
    }
    else if (t == MODULE_BODY) {
      r = moduleBody(b, 0);
    }
    else if (t == MODULE_DECLARATION) {
      r = moduleDeclaration(b, 0);
    }
    else if (t == MULTIPLICATIVE_EXPRESSION) {
      r = multiplicativeExpression(b, 0);
    }
    else if (t == NORMAL_PARAMETER_DECL) {
      r = normalParameterDecl(b, 0);
    }
    else if (t == OBJECT_CREATOR) {
      r = objectCreator(b, 0);
    }
    else if (t == PAR_EXPRESSION) {
      r = parExpression(b, 0);
    }
    else if (t == PRIMARY) {
      r = primary(b, 0);
    }
    else if (t == QUALIFIED_NAME) {
      r = qualifiedName(b, 0);
    }
    else if (t == QUALIFIED_NAME_LIST) {
      r = qualifiedNameList(b, 0);
    }
    else if (t == REFERENCE_EXPRESSION) {
      r = referenceExpression(b, 0);
    }
    else if (t == RELATIONAL_EXPRESSION) {
      r = relationalExpression(b, 0);
    }
    else if (t == RELATIONAL_OP) {
      r = relationalOp(b, 0);
    }
    else if (t == SELECTOR) {
      r = selector(b, 0);
    }
    else if (t == SHIFT_EXPRESSION) {
      r = shiftExpression(b, 0);
    }
    else if (t == SHIFT_OP) {
      r = shiftOp(b, 0);
    }
    else if (t == STATEMENT) {
      r = statement(b, 0);
    }
    else if (t == STRING_LITERAL) {
      r = stringLiteral(b, 0);
    }
    else if (t == SWITCH_BLOCK_STATEMENT_GROUP) {
      r = switchBlockStatementGroup(b, 0);
    }
    else if (t == SWITCH_BLOCK_STATEMENT_GROUPS) {
      r = switchBlockStatementGroups(b, 0);
    }
    else if (t == SWITCH_LABEL) {
      r = switchLabel(b, 0);
    }
    else if (t == SYMBOL) {
      r = symbol(b, 0);
    }
    else if (t == TRY_STATEMENT) {
      r = tryStatement(b, 0);
    }
    else if (t == TYPE) {
      r = type(b, 0);
    }
    else if (t == USING_DECLARATION) {
      r = usingDeclaration(b, 0);
    }
    else if (t == VARIABLE_DECLARATION_NAME) {
      r = variableDeclarationName(b, 0);
    }
    else if (t == VARIABLE_DECLARATOR) {
      r = variableDeclarator(b, 0);
    }
    else if (t == VARIABLE_INITIALIZER) {
      r = variableInitializer(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return monkeyCFile(b, l + 1);
  }

  /* ********************************************************** */
  // multiplicativeExpression ((PLUS | SUB) multiplicativeExpression)*
  public static boolean additiveExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<additive expression>");
    r = multiplicativeExpression(b, l + 1);
    r = r && additiveExpression_1(b, l + 1);
    exit_section_(b, l, m, ADDITIVE_EXPRESSION, r, false, null);
    return r;
  }

  // ((PLUS | SUB) multiplicativeExpression)*
  private static boolean additiveExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!additiveExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "additiveExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (PLUS | SUB) multiplicativeExpression
  private static boolean additiveExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = additiveExpression_1_0_0(b, l + 1);
    r = r && multiplicativeExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PLUS | SUB
  private static boolean additiveExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpression_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, SUB);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // equalityExpression (AMP equalityExpression)*
  public static boolean andExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "andExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<and expression>");
    r = equalityExpression(b, l + 1);
    r = r && andExpression_1(b, l + 1);
    exit_section_(b, l, m, AND_EXPRESSION, r, false, null);
    return r;
  }

  // (AMP equalityExpression)*
  private static boolean andExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "andExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!andExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "andExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // AMP equalityExpression
  private static boolean andExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "andExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AMP);
    r = r && equalityExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN symbol RPAREN
  public static boolean annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "annotation")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && symbol(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, ANNOTATION, r);
    return r;
  }

  /* ********************************************************** */
  // '(' (expressionList)? ')'
  public static boolean arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && arguments_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, ARGUMENTS, r);
    return r;
  }

  // (expressionList)?
  private static boolean arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1")) return false;
    arguments_1_0(b, l + 1);
    return true;
  }

  // (expressionList)
  private static boolean arguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expressionList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'new' '[' expression ']' // new [expression evaluating to integer]
  //                | '[' (expression (COMMA expression)* )? ']' // [expression1, expression2, ...]
  //                | dictionaryCreator
  public static boolean arrayCreator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayCreator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<array creator>");
    r = arrayCreator_0(b, l + 1);
    if (!r) r = arrayCreator_1(b, l + 1);
    if (!r) r = dictionaryCreator(b, l + 1);
    exit_section_(b, l, m, ARRAY_CREATOR, r, false, null);
    return r;
  }

  // 'new' '[' expression ']'
  private static boolean arrayCreator_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayCreator_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEW);
    r = r && consumeToken(b, LBRACKET);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' (expression (COMMA expression)* )? ']'
  private static boolean arrayCreator_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayCreator_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && arrayCreator_1_1(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // (expression (COMMA expression)* )?
  private static boolean arrayCreator_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayCreator_1_1")) return false;
    arrayCreator_1_1_0(b, l + 1);
    return true;
  }

  // expression (COMMA expression)*
  private static boolean arrayCreator_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayCreator_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && arrayCreator_1_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA expression)*
  private static boolean arrayCreator_1_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayCreator_1_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!arrayCreator_1_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arrayCreator_1_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA expression
  private static boolean arrayCreator_1_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayCreator_1_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' (variableInitializer (',' variableInitializer)*)? ','? '}'
  public static boolean arrayInitializer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayInitializer")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && arrayInitializer_1(b, l + 1);
    r = r && arrayInitializer_2(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, ARRAY_INITIALIZER, r);
    return r;
  }

  // (variableInitializer (',' variableInitializer)*)?
  private static boolean arrayInitializer_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayInitializer_1")) return false;
    arrayInitializer_1_0(b, l + 1);
    return true;
  }

  // variableInitializer (',' variableInitializer)*
  private static boolean arrayInitializer_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayInitializer_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variableInitializer(b, l + 1);
    r = r && arrayInitializer_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' variableInitializer)*
  private static boolean arrayInitializer_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayInitializer_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!arrayInitializer_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arrayInitializer_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' variableInitializer
  private static boolean arrayInitializer_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayInitializer_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && variableInitializer(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean arrayInitializer_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayInitializer_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // EQ
  //                      | PLUSEQ
  //                      | SUBEQ
  //                      | STAREQ
  //                      | SLASHEQ
  //                      | AMPEQ
  //                      | BAREQ
  //                      | CARETEQ
  //                      | PERCENTEQ
  //                      | LT LT EQ
  //                      | GT GT GT EQ
  //                      | GT GT EQ
  public static boolean assignmentOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignmentOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<assignment operator>");
    r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, PLUSEQ);
    if (!r) r = consumeToken(b, SUBEQ);
    if (!r) r = consumeToken(b, STAREQ);
    if (!r) r = consumeToken(b, SLASHEQ);
    if (!r) r = consumeToken(b, AMPEQ);
    if (!r) r = consumeToken(b, BAREQ);
    if (!r) r = consumeToken(b, CARETEQ);
    if (!r) r = consumeToken(b, PERCENTEQ);
    if (!r) r = parseTokens(b, 0, LT, LT, EQ);
    if (!r) r = parseTokens(b, 0, GT, GT, GT, EQ);
    if (!r) r = parseTokens(b, 0, GT, GT, EQ);
    exit_section_(b, l, m, ASSIGNMENT_OPERATOR, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // unaryExpression (bitwiseOperator unaryExpression)*
  public static boolean bitwiseExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<bitwise expression>");
    r = unaryExpression(b, l + 1);
    r = r && bitwiseExpression_1(b, l + 1);
    exit_section_(b, l, m, BITWISE_EXPRESSION, r, false, null);
    return r;
  }

  // (bitwiseOperator unaryExpression)*
  private static boolean bitwiseExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!bitwiseExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bitwiseExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // bitwiseOperator unaryExpression
  private static boolean bitwiseExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bitwiseOperator(b, l + 1);
    r = r && unaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // AMP | CARET| BAR
  public static boolean bitwiseOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<bitwise operator>");
    r = consumeToken(b, AMP);
    if (!r) r = consumeToken(b, CARET);
    if (!r) r = consumeToken(b, BAR);
    exit_section_(b, l, m, BITWISE_OPERATOR, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' blockStatement* '}'
  public static boolean block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && block_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  // blockStatement*
  private static boolean block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!blockStatement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // localVariableDeclarationStatement
  //                  | classDeclaration
  //                  | statement
  public static boolean blockStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<block statement>");
    r = localVariableDeclarationStatement(b, l + 1);
    if (!r) r = classDeclaration(b, l + 1);
    if (!r) r = statement(b, l + 1);
    exit_section_(b, l, m, BLOCK_STATEMENT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CATCH LPAREN catchParameter RPAREN block
  public static boolean catchClause(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "catchClause")) return false;
    if (!nextTokenIs(b, CATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CATCH, LPAREN);
    r = r && catchParameter(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && block(b, l + 1);
    exit_section_(b, m, CATCH_CLAUSE, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER ('[' ']')*
  public static boolean catchParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "catchParameter")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && catchParameter_1(b, l + 1);
    exit_section_(b, m, CATCH_PARAMETER, r);
    return r;
  }

  // ('[' ']')*
  private static boolean catchParameter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "catchParameter_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!catchParameter_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "catchParameter_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // '[' ']'
  private static boolean catchParameter_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "catchParameter_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // catchClause (catchClause)*
  public static boolean catches(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "catches")) return false;
    if (!nextTokenIs(b, CATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = catchClause(b, l + 1);
    r = r && catches_1(b, l + 1);
    exit_section_(b, m, CATCHES, r);
    return r;
  }

  // (catchClause)*
  private static boolean catches_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "catches_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!catches_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "catches_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (catchClause)
  private static boolean catches_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "catches_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = catchClause(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' classBodyDeclaration* '}'
  public static boolean classBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classBody")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && classBody_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, CLASS_BODY, r);
    return r;
  }

  // classBodyDeclaration*
  private static boolean classBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classBody_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!classBodyDeclaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "classBody_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // usingDeclaration | block | constDeclaration | fieldDeclaration | functionDeclaration | classDeclaration | SEMI
  public static boolean classBodyDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classBodyDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<class body declaration>");
    r = usingDeclaration(b, l + 1);
    if (!r) r = block(b, l + 1);
    if (!r) r = constDeclaration(b, l + 1);
    if (!r) r = fieldDeclaration(b, l + 1);
    if (!r) r = functionDeclaration(b, l + 1);
    if (!r) r = classDeclaration(b, l + 1);
    if (!r) r = consumeToken(b, SEMI);
    exit_section_(b, l, m, CLASS_BODY_DECLARATION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // arguments classBody?
  public static boolean classCreatorRest(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classCreatorRest")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arguments(b, l + 1);
    r = r && classCreatorRest_1(b, l + 1);
    exit_section_(b, m, CLASS_CREATOR_REST, r);
    return r;
  }

  // classBody?
  private static boolean classCreatorRest_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classCreatorRest_1")) return false;
    classBody(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // modifiers 'class' className (EXTENDS type)? classBody
  //                    | modifiers ENUM componentName? enumBody
  public static boolean classDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<class declaration>");
    r = classDeclaration_0(b, l + 1);
    if (!r) r = classDeclaration_1(b, l + 1);
    exit_section_(b, l, m, CLASS_DECLARATION, r, false, null);
    return r;
  }

  // modifiers 'class' className (EXTENDS type)? classBody
  private static boolean classDeclaration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classDeclaration_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = modifiers(b, l + 1);
    r = r && consumeToken(b, CLASS);
    r = r && className(b, l + 1);
    r = r && classDeclaration_0_3(b, l + 1);
    r = r && classBody(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (EXTENDS type)?
  private static boolean classDeclaration_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classDeclaration_0_3")) return false;
    classDeclaration_0_3_0(b, l + 1);
    return true;
  }

  // EXTENDS type
  private static boolean classDeclaration_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classDeclaration_0_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // modifiers ENUM componentName? enumBody
  private static boolean classDeclaration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classDeclaration_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = modifiers(b, l + 1);
    r = r && consumeToken(b, ENUM);
    r = r && classDeclaration_1_2(b, l + 1);
    r = r && enumBody(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // componentName?
  private static boolean classDeclaration_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "classDeclaration_1_2")) return false;
    componentName(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // componentName
  public static boolean className(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "className")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = componentName(b, l + 1);
    exit_section_(b, m, CLASS_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // usingDeclaration | moduleDeclaration | constDeclaration | fieldDeclaration
  //                           | functionDeclaration | classDeclaration | blockStatement | SEMI
  static boolean compilationUnit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compilationUnit")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = usingDeclaration(b, l + 1);
    if (!r) r = moduleDeclaration(b, l + 1);
    if (!r) r = constDeclaration(b, l + 1);
    if (!r) r = fieldDeclaration(b, l + 1);
    if (!r) r = functionDeclaration(b, l + 1);
    if (!r) r = classDeclaration(b, l + 1);
    if (!r) r = blockStatement(b, l + 1);
    if (!r) r = consumeToken(b, SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // id
  public static boolean componentName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "componentName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = id(b, l + 1);
    exit_section_(b, m, COMPONENT_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // inclusiveOrExpression ((AMPAMP | AND) inclusiveOrExpression)*
  public static boolean conditionalAndExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalAndExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<conditional and expression>");
    r = inclusiveOrExpression(b, l + 1);
    r = r && conditionalAndExpression_1(b, l + 1);
    exit_section_(b, l, m, CONDITIONAL_AND_EXPRESSION, r, false, null);
    return r;
  }

  // ((AMPAMP | AND) inclusiveOrExpression)*
  private static boolean conditionalAndExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalAndExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!conditionalAndExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "conditionalAndExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (AMPAMP | AND) inclusiveOrExpression
  private static boolean conditionalAndExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalAndExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = conditionalAndExpression_1_0_0(b, l + 1);
    r = r && inclusiveOrExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // AMPAMP | AND
  private static boolean conditionalAndExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalAndExpression_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AMPAMP);
    if (!r) r = consumeToken(b, AND);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // conditionalOrExpression (QUES expression COLON conditionalExpression)?
  public static boolean conditionalExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<conditional expression>");
    r = conditionalOrExpression(b, l + 1);
    r = r && conditionalExpression_1(b, l + 1);
    exit_section_(b, l, m, CONDITIONAL_EXPRESSION, r, false, null);
    return r;
  }

  // (QUES expression COLON conditionalExpression)?
  private static boolean conditionalExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalExpression_1")) return false;
    conditionalExpression_1_0(b, l + 1);
    return true;
  }

  // QUES expression COLON conditionalExpression
  private static boolean conditionalExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUES);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && conditionalExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // conditionalAndExpression ((BARBAR | OR) conditionalAndExpression)*
  public static boolean conditionalOrExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalOrExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<conditional or expression>");
    r = conditionalAndExpression(b, l + 1);
    r = r && conditionalOrExpression_1(b, l + 1);
    exit_section_(b, l, m, CONDITIONAL_OR_EXPRESSION, r, false, null);
    return r;
  }

  // ((BARBAR | OR) conditionalAndExpression)*
  private static boolean conditionalOrExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalOrExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!conditionalOrExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "conditionalOrExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (BARBAR | OR) conditionalAndExpression
  private static boolean conditionalOrExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalOrExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = conditionalOrExpression_1_0_0(b, l + 1);
    r = r && conditionalAndExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // BARBAR | OR
  private static boolean conditionalOrExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditionalOrExpression_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BARBAR);
    if (!r) r = consumeToken(b, OR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // modifiers 'const' variableDeclarator SEMI
  public static boolean constDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<const declaration>");
    r = modifiers(b, l + 1);
    r = r && consumeToken(b, CONST);
    r = r && variableDeclarator(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, l, m, CONST_DECLARATION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // objectCreator | arrayCreator
  public static boolean creator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "creator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<creator>");
    r = objectCreator(b, l + 1);
    if (!r) r = arrayCreator(b, l + 1);
    exit_section_(b, l, m, CREATOR, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'new' '{' '}' // new {}
  //                     | '{' (keyValueInitializer (',' keyValueInitializer)* )? '}'
  public static boolean dictionaryCreator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryCreator")) return false;
    if (!nextTokenIs(b, "<dictionary creator>", NEW, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<dictionary creator>");
    r = dictionaryCreator_0(b, l + 1);
    if (!r) r = dictionaryCreator_1(b, l + 1);
    exit_section_(b, l, m, DICTIONARY_CREATOR, r, false, null);
    return r;
  }

  // 'new' '{' '}'
  private static boolean dictionaryCreator_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryCreator_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEW);
    r = r && consumeToken(b, LBRACE);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // '{' (keyValueInitializer (',' keyValueInitializer)* )? '}'
  private static boolean dictionaryCreator_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryCreator_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && dictionaryCreator_1_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (keyValueInitializer (',' keyValueInitializer)* )?
  private static boolean dictionaryCreator_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryCreator_1_1")) return false;
    dictionaryCreator_1_1_0(b, l + 1);
    return true;
  }

  // keyValueInitializer (',' keyValueInitializer)*
  private static boolean dictionaryCreator_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryCreator_1_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = keyValueInitializer(b, l + 1);
    r = r && dictionaryCreator_1_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' keyValueInitializer)*
  private static boolean dictionaryCreator_1_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryCreator_1_1_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!dictionaryCreator_1_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dictionaryCreator_1_1_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' keyValueInitializer
  private static boolean dictionaryCreator_1_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dictionaryCreator_1_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && keyValueInitializer(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' enumConstants? COMMA? enumBodyDeclarations? '}'
  public static boolean enumBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumBody")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && enumBody_1(b, l + 1);
    r = r && enumBody_2(b, l + 1);
    r = r && enumBody_3(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, ENUM_BODY, r);
    return r;
  }

  // enumConstants?
  private static boolean enumBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumBody_1")) return false;
    enumConstants(b, l + 1);
    return true;
  }

  // COMMA?
  private static boolean enumBody_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumBody_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // enumBodyDeclarations?
  private static boolean enumBody_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumBody_3")) return false;
    enumBodyDeclarations(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SEMI classBodyDeclaration*
  public static boolean enumBodyDeclarations(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumBodyDeclarations")) return false;
    if (!nextTokenIs(b, SEMI)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMI);
    r = r && enumBodyDeclarations_1(b, l + 1);
    exit_section_(b, m, ENUM_BODY_DECLARATIONS, r);
    return r;
  }

  // classBodyDeclaration*
  private static boolean enumBodyDeclarations_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumBodyDeclarations_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!classBodyDeclaration(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enumBodyDeclarations_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // componentName (EQ INTLITERAL)?
  public static boolean enumConstant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumConstant")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = componentName(b, l + 1);
    r = r && enumConstant_1(b, l + 1);
    exit_section_(b, m, ENUM_CONSTANT, r);
    return r;
  }

  // (EQ INTLITERAL)?
  private static boolean enumConstant_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumConstant_1")) return false;
    enumConstant_1_0(b, l + 1);
    return true;
  }

  // EQ INTLITERAL
  private static boolean enumConstant_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumConstant_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, EQ, INTLITERAL);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // enumConstant (COMMA enumConstant)*
  public static boolean enumConstants(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumConstants")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enumConstant(b, l + 1);
    r = r && enumConstants_1(b, l + 1);
    exit_section_(b, m, ENUM_CONSTANTS, r);
    return r;
  }

  // (COMMA enumConstant)*
  private static boolean enumConstants_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumConstants_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!enumConstants_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enumConstants_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA enumConstant
  private static boolean enumConstants_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumConstants_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && enumConstant(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // hasExpression ((EQEQ | BANGEQ) hasExpression)*
  public static boolean equalityExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalityExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<equality expression>");
    r = hasExpression(b, l + 1);
    r = r && equalityExpression_1(b, l + 1);
    exit_section_(b, l, m, EQUALITY_EXPRESSION, r, false, null);
    return r;
  }

  // ((EQEQ | BANGEQ) hasExpression)*
  private static boolean equalityExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalityExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!equalityExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "equalityExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (EQEQ | BANGEQ) hasExpression
  private static boolean equalityExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalityExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = equalityExpression_1_0_0(b, l + 1);
    r = r && hasExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EQEQ | BANGEQ
  private static boolean equalityExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalityExpression_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQEQ);
    if (!r) r = consumeToken(b, BANGEQ);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // andExpression (CARET andExpression)*
  public static boolean exclusiveOrExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exclusiveOrExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<exclusive or expression>");
    r = andExpression(b, l + 1);
    r = r && exclusiveOrExpression_1(b, l + 1);
    exit_section_(b, l, m, EXCLUSIVE_OR_EXPRESSION, r, false, null);
    return r;
  }

  // (CARET andExpression)*
  private static boolean exclusiveOrExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exclusiveOrExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!exclusiveOrExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "exclusiveOrExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // CARET andExpression
  private static boolean exclusiveOrExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exclusiveOrExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CARET);
    r = r && andExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SUPER arguments SEMI
  //                                 | primary DOT SUPER arguments SEMI
  public static boolean explicitConstructorInvocation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "explicitConstructorInvocation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<explicit constructor invocation>");
    r = explicitConstructorInvocation_0(b, l + 1);
    if (!r) r = explicitConstructorInvocation_1(b, l + 1);
    exit_section_(b, l, m, EXPLICIT_CONSTRUCTOR_INVOCATION, r, false, null);
    return r;
  }

  // SUPER arguments SEMI
  private static boolean explicitConstructorInvocation_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "explicitConstructorInvocation_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUPER);
    r = r && arguments(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // primary DOT SUPER arguments SEMI
  private static boolean explicitConstructorInvocation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "explicitConstructorInvocation_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primary(b, l + 1);
    r = r && consumeTokens(b, 0, DOT, SUPER);
    r = r && arguments(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // conditionalExpression (assignmentOperator expression)?
  public static boolean expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<expression>");
    r = conditionalExpression(b, l + 1);
    r = r && expression_1(b, l + 1);
    exit_section_(b, l, m, EXPRESSION, r, false, null);
    return r;
  }

  // (assignmentOperator expression)?
  private static boolean expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1")) return false;
    expression_1_0(b, l + 1);
    return true;
  }

  // assignmentOperator expression
  private static boolean expression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignmentOperator(b, l + 1);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expression (COMMA expression)*
  public static boolean expressionList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<expression list>");
    r = expression(b, l + 1);
    r = r && expressionList_1(b, l + 1);
    exit_section_(b, l, m, EXPRESSION_LIST, r, false, null);
    return r;
  }

  // (COMMA expression)*
  private static boolean expressionList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!expressionList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expressionList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA expression
  private static boolean expressionList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expressionList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // modifiers 'var' variableDeclarator
  //                     (COMMA variableDeclarator)* SEMI
  public static boolean fieldDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<field declaration>");
    r = modifiers(b, l + 1);
    r = r && consumeToken(b, VAR);
    r = r && variableDeclarator(b, l + 1);
    r = r && fieldDeclaration_3(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, l, m, FIELD_DECLARATION, r, false, null);
    return r;
  }

  // (COMMA variableDeclarator)*
  private static boolean fieldDeclaration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldDeclaration_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!fieldDeclaration_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fieldDeclaration_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA variableDeclarator
  private static boolean fieldDeclaration_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldDeclaration_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && variableDeclarator(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // localVariableDeclaration| expressionList
  public static boolean forInit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forInit")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<for init>");
    r = localVariableDeclaration(b, l + 1);
    if (!r) r = expressionList(b, l + 1);
    exit_section_(b, l, m, FOR_INIT, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FOR LPAREN forInit? SEMI expression? SEMI expressionList? RPAREN statement
  public static boolean forStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forStatement")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FOR, LPAREN);
    r = r && forStatement_2(b, l + 1);
    r = r && consumeToken(b, SEMI);
    r = r && forStatement_4(b, l + 1);
    r = r && consumeToken(b, SEMI);
    r = r && forStatement_6(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && statement(b, l + 1);
    exit_section_(b, m, FOR_STATEMENT, r);
    return r;
  }

  // forInit?
  private static boolean forStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forStatement_2")) return false;
    forInit(b, l + 1);
    return true;
  }

  // expression?
  private static boolean forStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forStatement_4")) return false;
    expression(b, l + 1);
    return true;
  }

  // expressionList?
  private static boolean forStatement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forStatement_6")) return false;
    expressionList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // normalParameterDecl (COMMA normalParameterDecl)*
  public static boolean formalParameterDecls(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formalParameterDecls")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = normalParameterDecl(b, l + 1);
    r = r && formalParameterDecls_1(b, l + 1);
    exit_section_(b, m, FORMAL_PARAMETER_DECLS, r);
    return r;
  }

  // (COMMA normalParameterDecl)*
  private static boolean formalParameterDecls_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formalParameterDecls_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!formalParameterDecls_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "formalParameterDecls_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA normalParameterDecl
  private static boolean formalParameterDecls_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formalParameterDecls_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && normalParameterDecl(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN (formalParameterDecls)? RPAREN
  public static boolean formalParameters(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formalParameters")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && formalParameters_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, FORMAL_PARAMETERS, r);
    return r;
  }

  // (formalParameterDecls)?
  private static boolean formalParameters_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formalParameters_1")) return false;
    formalParameters_1_0(b, l + 1);
    return true;
  }

  // (formalParameterDecls)
  private static boolean formalParameters_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formalParameters_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = formalParameterDecls(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // modifiers 'function' componentName formalParameters (THROWS qualifiedNameList)?
  //                         '{' (explicitConstructorInvocation)? (blockStatement)* '}'
  public static boolean functionDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<function declaration>");
    r = modifiers(b, l + 1);
    r = r && consumeToken(b, FUNCTION);
    r = r && componentName(b, l + 1);
    p = r; // pin = 3
    r = r && report_error_(b, formalParameters(b, l + 1));
    r = p && report_error_(b, functionDeclaration_4(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, LBRACE)) && r;
    r = p && report_error_(b, functionDeclaration_6(b, l + 1)) && r;
    r = p && report_error_(b, functionDeclaration_7(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, FUNCTION_DECLARATION, r, p, null);
    return r || p;
  }

  // (THROWS qualifiedNameList)?
  private static boolean functionDeclaration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration_4")) return false;
    functionDeclaration_4_0(b, l + 1);
    return true;
  }

  // THROWS qualifiedNameList
  private static boolean functionDeclaration_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THROWS);
    r = r && qualifiedNameList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (explicitConstructorInvocation)?
  private static boolean functionDeclaration_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration_6")) return false;
    functionDeclaration_6_0(b, l + 1);
    return true;
  }

  // (explicitConstructorInvocation)
  private static boolean functionDeclaration_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = explicitConstructorInvocation(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (blockStatement)*
  private static boolean functionDeclaration_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration_7")) return false;
    int c = current_position_(b);
    while (true) {
      if (!functionDeclaration_7_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functionDeclaration_7", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (blockStatement)
  private static boolean functionDeclaration_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDeclaration_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = blockStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // instanceOfExpression (HAS symbol)?
  public static boolean hasExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hasExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<has expression>");
    r = instanceOfExpression(b, l + 1);
    r = r && hasExpression_1(b, l + 1);
    exit_section_(b, l, m, HAS_EXPRESSION, r, false, null);
    return r;
  }

  // (HAS symbol)?
  private static boolean hasExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hasExpression_1")) return false;
    hasExpression_1_0(b, l + 1);
    return true;
  }

  // HAS symbol
  private static boolean hasExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hasExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, HAS);
    r = r && symbol(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean id(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "id")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, ID, r);
    return r;
  }

  /* ********************************************************** */
  // ('[' expression? ']')+
  //                    | arguments
  public static boolean identifierSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifierSuffix")) return false;
    if (!nextTokenIs(b, "<identifier suffix>", LPAREN, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<identifier suffix>");
    r = identifierSuffix_0(b, l + 1);
    if (!r) r = arguments(b, l + 1);
    exit_section_(b, l, m, IDENTIFIER_SUFFIX, r, false, null);
    return r;
  }

  // ('[' expression? ']')+
  private static boolean identifierSuffix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifierSuffix_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifierSuffix_0_0(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!identifierSuffix_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "identifierSuffix_0", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' expression? ']'
  private static boolean identifierSuffix_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifierSuffix_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && identifierSuffix_0_0_1(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression?
  private static boolean identifierSuffix_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifierSuffix_0_0_1")) return false;
    expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // exclusiveOrExpression (BAR exclusiveOrExpression)*
  public static boolean inclusiveOrExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inclusiveOrExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<inclusive or expression>");
    r = exclusiveOrExpression(b, l + 1);
    r = r && inclusiveOrExpression_1(b, l + 1);
    exit_section_(b, l, m, INCLUSIVE_OR_EXPRESSION, r, false, null);
    return r;
  }

  // (BAR exclusiveOrExpression)*
  private static boolean inclusiveOrExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inclusiveOrExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!inclusiveOrExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "inclusiveOrExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // BAR exclusiveOrExpression
  private static boolean inclusiveOrExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "inclusiveOrExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BAR);
    r = r && exclusiveOrExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // relationalExpression (INSTANCEOF type)?
  public static boolean instanceOfExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instanceOfExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<instance of expression>");
    r = relationalExpression(b, l + 1);
    r = r && instanceOfExpression_1(b, l + 1);
    exit_section_(b, l, m, INSTANCE_OF_EXPRESSION, r, false, null);
    return r;
  }

  // (INSTANCEOF type)?
  private static boolean instanceOfExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instanceOfExpression_1")) return false;
    instanceOfExpression_1_0(b, l + 1);
    return true;
  }

  // INSTANCEOF type
  private static boolean instanceOfExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "instanceOfExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INSTANCEOF);
    r = r && type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // primary EQGT expression
  public static boolean keyValueInitializer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "keyValueInitializer")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<key value initializer>");
    r = primary(b, l + 1);
    r = r && consumeToken(b, EQGT);
    r = r && expression(b, l + 1);
    exit_section_(b, l, m, KEY_VALUE_INITIALIZER, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // INTLITERAL
  //           | LONGLITERAL
  //           | FLOATLITERAL
  //           | DOUBLELITERAL
  //           | HEX_LITERAL
  //           | CHARLITERAL
  //           | stringLiteral
  //           | TRUE
  //           | FALSE
  //           | NULL
  public static boolean literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<literal>");
    r = consumeToken(b, INTLITERAL);
    if (!r) r = consumeToken(b, LONGLITERAL);
    if (!r) r = consumeToken(b, FLOATLITERAL);
    if (!r) r = consumeToken(b, DOUBLELITERAL);
    if (!r) r = consumeToken(b, HEX_LITERAL);
    if (!r) r = consumeToken(b, CHARLITERAL);
    if (!r) r = stringLiteral(b, l + 1);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, NULL);
    exit_section_(b, l, m, LITERAL, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'var' variableDeclarator (COMMA variableDeclarator)*
  public static boolean localVariableDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "localVariableDeclaration")) return false;
    if (!nextTokenIs(b, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VAR);
    r = r && variableDeclarator(b, l + 1);
    r = r && localVariableDeclaration_2(b, l + 1);
    exit_section_(b, m, LOCAL_VARIABLE_DECLARATION, r);
    return r;
  }

  // (COMMA variableDeclarator)*
  private static boolean localVariableDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "localVariableDeclaration_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!localVariableDeclaration_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "localVariableDeclaration_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA variableDeclarator
  private static boolean localVariableDeclaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "localVariableDeclaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && variableDeclarator(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // localVariableDeclaration SEMI
  public static boolean localVariableDeclarationStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "localVariableDeclarationStatement")) return false;
    if (!nextTokenIs(b, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = localVariableDeclaration(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, LOCAL_VARIABLE_DECLARATION_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // annotation? STATIC? HIDDEN?
  public static boolean modifiers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<modifiers>");
    r = modifiers_0(b, l + 1);
    r = r && modifiers_1(b, l + 1);
    r = r && modifiers_2(b, l + 1);
    exit_section_(b, l, m, MODIFIERS, r, false, null);
    return r;
  }

  // annotation?
  private static boolean modifiers_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers_0")) return false;
    annotation(b, l + 1);
    return true;
  }

  // STATIC?
  private static boolean modifiers_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers_1")) return false;
    consumeToken(b, STATIC);
    return true;
  }

  // HIDDEN?
  private static boolean modifiers_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifiers_2")) return false;
    consumeToken(b, HIDDEN);
    return true;
  }

  /* ********************************************************** */
  // classBody
  public static boolean moduleBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleBody")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = classBody(b, l + 1);
    exit_section_(b, m, MODULE_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // modifiers 'module' componentName moduleBody
  public static boolean moduleDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleDeclaration")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<module declaration>");
    r = modifiers(b, l + 1);
    r = r && consumeToken(b, MODULE);
    r = r && componentName(b, l + 1);
    r = r && moduleBody(b, l + 1);
    exit_section_(b, l, m, MODULE_DECLARATION, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // compilationUnit*
  static boolean monkeyCFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "monkeyCFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!compilationUnit(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "monkeyCFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // bitwiseExpression ((STAR | SLASH | PERCENT) unaryExpression)*
  public static boolean multiplicativeExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<multiplicative expression>");
    r = bitwiseExpression(b, l + 1);
    r = r && multiplicativeExpression_1(b, l + 1);
    exit_section_(b, l, m, MULTIPLICATIVE_EXPRESSION, r, false, null);
    return r;
  }

  // ((STAR | SLASH | PERCENT) unaryExpression)*
  private static boolean multiplicativeExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!multiplicativeExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiplicativeExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (STAR | SLASH | PERCENT) unaryExpression
  private static boolean multiplicativeExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplicativeExpression_1_0_0(b, l + 1);
    r = r && unaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // STAR | SLASH | PERCENT
  private static boolean multiplicativeExpression_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpression_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, SLASH);
    if (!r) r = consumeToken(b, PERCENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // componentName ('[' ']')*
  public static boolean normalParameterDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normalParameterDecl")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = componentName(b, l + 1);
    r = r && normalParameterDecl_1(b, l + 1);
    exit_section_(b, m, NORMAL_PARAMETER_DECL, r);
    return r;
  }

  // ('[' ']')*
  private static boolean normalParameterDecl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normalParameterDecl_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!normalParameterDecl_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "normalParameterDecl_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // '[' ']'
  private static boolean normalParameterDecl_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "normalParameterDecl_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'new' qualifiedName classCreatorRest
  public static boolean objectCreator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "objectCreator")) return false;
    if (!nextTokenIs(b, NEW)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, NEW);
    r = r && qualifiedName(b, l + 1);
    p = r; // pin = 2
    r = r && classCreatorRest(b, l + 1);
    exit_section_(b, l, m, OBJECT_CREATOR, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // LPAREN expression RPAREN
  public static boolean parExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parExpression")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, PAR_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // parExpression
  //           | qualifiedReferenceExpression
  //           | literal
  //           | symbol
  //           | creator
  //           | VOID '.' 'class' {
  // }
  public static boolean primary(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<primary>");
    r = parExpression(b, l + 1);
    if (!r) r = qualifiedReferenceExpression(b, l + 1);
    if (!r) r = literal(b, l + 1);
    if (!r) r = symbol(b, l + 1);
    if (!r) r = creator(b, l + 1);
    if (!r) r = primary_5(b, l + 1);
    exit_section_(b, l, m, PRIMARY, r, false, null);
    return r;
  }

  // VOID '.' 'class' {
  // }
  private static boolean primary_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VOID);
    r = r && consumeToken(b, DOT);
    r = r && consumeToken(b, CLASS);
    r = r && primary_5_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // {
  // }
  private static boolean primary_5_3(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // componentName (DOT componentName)*
  public static boolean qualifiedName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualifiedName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = componentName(b, l + 1);
    r = r && qualifiedName_1(b, l + 1);
    exit_section_(b, m, QUALIFIED_NAME, r);
    return r;
  }

  // (DOT componentName)*
  private static boolean qualifiedName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualifiedName_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!qualifiedName_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "qualifiedName_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // DOT componentName
  private static boolean qualifiedName_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualifiedName_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && componentName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // qualifiedName (COMMA qualifiedName)*
  public static boolean qualifiedNameList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualifiedNameList")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = qualifiedName(b, l + 1);
    r = r && qualifiedNameList_1(b, l + 1);
    exit_section_(b, m, QUALIFIED_NAME_LIST, r);
    return r;
  }

  // (COMMA qualifiedName)*
  private static boolean qualifiedNameList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualifiedNameList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!qualifiedNameList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "qualifiedNameList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // COMMA qualifiedName
  private static boolean qualifiedNameList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualifiedNameList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && qualifiedName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // referenceExpression ('.' referenceExpression)*
  public static boolean qualifiedReferenceExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualifiedReferenceExpression")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, null);
    r = referenceExpression(b, l + 1);
    r = r && qualifiedReferenceExpression_1(b, l + 1);
    exit_section_(b, l, m, REFERENCE_EXPRESSION, r, false, null);
    return r;
  }

  // ('.' referenceExpression)*
  private static boolean qualifiedReferenceExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualifiedReferenceExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!qualifiedReferenceExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "qualifiedReferenceExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // '.' referenceExpression
  private static boolean qualifiedReferenceExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qualifiedReferenceExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && referenceExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // componentName identifierSuffix?
  public static boolean referenceExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceExpression")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = componentName(b, l + 1);
    r = r && referenceExpression_1(b, l + 1);
    exit_section_(b, m, REFERENCE_EXPRESSION, r);
    return r;
  }

  // identifierSuffix?
  private static boolean referenceExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "referenceExpression_1")) return false;
    identifierSuffix(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // shiftExpression (relationalOp shiftExpression)*
  public static boolean relationalExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationalExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<relational expression>");
    r = shiftExpression(b, l + 1);
    r = r && relationalExpression_1(b, l + 1);
    exit_section_(b, l, m, RELATIONAL_EXPRESSION, r, false, null);
    return r;
  }

  // (relationalOp shiftExpression)*
  private static boolean relationalExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationalExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!relationalExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "relationalExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // relationalOp shiftExpression
  private static boolean relationalExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationalExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relationalOp(b, l + 1);
    r = r && shiftExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LT EQ | GT EQ | LT | GT
  public static boolean relationalOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationalOp")) return false;
    if (!nextTokenIs(b, "<relational op>", GT, LT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<relational op>");
    r = parseTokens(b, 0, LT, EQ);
    if (!r) r = parseTokens(b, 0, GT, EQ);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, GT);
    exit_section_(b, l, m, RELATIONAL_OP, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '.' id (arguments)?
  //            | '[' expression ']'
  public static boolean selector(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selector")) return false;
    if (!nextTokenIs(b, "<selector>", DOT, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<selector>");
    r = selector_0(b, l + 1);
    if (!r) r = selector_1(b, l + 1);
    exit_section_(b, l, m, SELECTOR, r, false, null);
    return r;
  }

  // '.' id (arguments)?
  private static boolean selector_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selector_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && id(b, l + 1);
    r = r && selector_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (arguments)?
  private static boolean selector_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selector_0_2")) return false;
    selector_0_2_0(b, l + 1);
    return true;
  }

  // (arguments)
  private static boolean selector_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selector_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arguments(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' expression ']'
  private static boolean selector_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "selector_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // additiveExpression (shiftOp additiveExpression)*
  public static boolean shiftExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shiftExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<shift expression>");
    r = additiveExpression(b, l + 1);
    r = r && shiftExpression_1(b, l + 1);
    exit_section_(b, l, m, SHIFT_EXPRESSION, r, false, null);
    return r;
  }

  // (shiftOp additiveExpression)*
  private static boolean shiftExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shiftExpression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!shiftExpression_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "shiftExpression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // shiftOp additiveExpression
  private static boolean shiftExpression_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shiftExpression_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = shiftOp(b, l + 1);
    r = r && additiveExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LT LT | GT GT GT | GT GT
  public static boolean shiftOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shiftOp")) return false;
    if (!nextTokenIs(b, "<shift op>", GT, LT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<shift op>");
    r = parseTokens(b, 0, LT, LT);
    if (!r) r = parseTokens(b, 0, GT, GT, GT);
    if (!r) r = parseTokens(b, 0, GT, GT);
    exit_section_(b, l, m, SHIFT_OP, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // block
  //             | IF parExpression statement (ELSE statement)?
  //             | forStatement
  //             | WHILE parExpression statement
  //             | DO statement WHILE parExpression SEMI
  //             | tryStatement
  //             | SWITCH parExpression '{' switchBlockStatementGroups '}'
  //             | 'return' expression? SEMI
  //             | THROW expression SEMI
  //             | BREAK referenceExpression? SEMI
  //             | CONTINUE referenceExpression? SEMI
  //             | expression SEMI
  //             | IDENTIFIER COLON statement
  //             | SEMI
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<statement>");
    r = block(b, l + 1);
    if (!r) r = statement_1(b, l + 1);
    if (!r) r = forStatement(b, l + 1);
    if (!r) r = statement_3(b, l + 1);
    if (!r) r = statement_4(b, l + 1);
    if (!r) r = tryStatement(b, l + 1);
    if (!r) r = statement_6(b, l + 1);
    if (!r) r = statement_7(b, l + 1);
    if (!r) r = statement_8(b, l + 1);
    if (!r) r = statement_9(b, l + 1);
    if (!r) r = statement_10(b, l + 1);
    if (!r) r = statement_11(b, l + 1);
    if (!r) r = statement_12(b, l + 1);
    if (!r) r = consumeToken(b, SEMI);
    exit_section_(b, l, m, STATEMENT, r, false, null);
    return r;
  }

  // IF parExpression statement (ELSE statement)?
  private static boolean statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && parExpression(b, l + 1);
    r = r && statement(b, l + 1);
    r = r && statement_1_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ELSE statement)?
  private static boolean statement_1_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1_3")) return false;
    statement_1_3_0(b, l + 1);
    return true;
  }

  // ELSE statement
  private static boolean statement_1_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // WHILE parExpression statement
  private static boolean statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && parExpression(b, l + 1);
    r = r && statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DO statement WHILE parExpression SEMI
  private static boolean statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DO);
    r = r && statement(b, l + 1);
    r = r && consumeToken(b, WHILE);
    r = r && parExpression(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // SWITCH parExpression '{' switchBlockStatementGroups '}'
  private static boolean statement_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SWITCH);
    r = r && parExpression(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    r = r && switchBlockStatementGroups(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'return' expression? SEMI
  private static boolean statement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && statement_7_1(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // expression?
  private static boolean statement_7_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_7_1")) return false;
    expression(b, l + 1);
    return true;
  }

  // THROW expression SEMI
  private static boolean statement_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, THROW);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // BREAK referenceExpression? SEMI
  private static boolean statement_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BREAK);
    r = r && statement_9_1(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // referenceExpression?
  private static boolean statement_9_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_9_1")) return false;
    referenceExpression(b, l + 1);
    return true;
  }

  // CONTINUE referenceExpression? SEMI
  private static boolean statement_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONTINUE);
    r = r && statement_10_1(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // referenceExpression?
  private static boolean statement_10_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_10_1")) return false;
    referenceExpression(b, l + 1);
    return true;
  }

  // expression SEMI
  private static boolean statement_11(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_11")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expression(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER COLON statement
  private static boolean statement_12(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_12")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, COLON);
    r = r && statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // string
  public static boolean stringLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringLiteral")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, STRING_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // switchLabel (blockStatement)*
  public static boolean switchBlockStatementGroup(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchBlockStatementGroup")) return false;
    if (!nextTokenIs(b, "<switch block statement group>", CASE, DEFAULT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<switch block statement group>");
    r = switchLabel(b, l + 1);
    r = r && switchBlockStatementGroup_1(b, l + 1);
    exit_section_(b, l, m, SWITCH_BLOCK_STATEMENT_GROUP, r, false, null);
    return r;
  }

  // (blockStatement)*
  private static boolean switchBlockStatementGroup_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchBlockStatementGroup_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!switchBlockStatementGroup_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "switchBlockStatementGroup_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // (blockStatement)
  private static boolean switchBlockStatementGroup_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchBlockStatementGroup_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = blockStatement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (switchBlockStatementGroup)*
  public static boolean switchBlockStatementGroups(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchBlockStatementGroups")) return false;
    Marker m = enter_section_(b, l, _NONE_, "<switch block statement groups>");
    int c = current_position_(b);
    while (true) {
      if (!switchBlockStatementGroups_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "switchBlockStatementGroups", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, SWITCH_BLOCK_STATEMENT_GROUPS, true, false, null);
    return true;
  }

  // (switchBlockStatementGroup)
  private static boolean switchBlockStatementGroups_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchBlockStatementGroups_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = switchBlockStatementGroup(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CASE expression COLON | DEFAULT COLON
  public static boolean switchLabel(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchLabel")) return false;
    if (!nextTokenIs(b, "<switch label>", CASE, DEFAULT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<switch label>");
    r = switchLabel_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, DEFAULT, COLON);
    exit_section_(b, l, m, SWITCH_LABEL, r, false, null);
    return r;
  }

  // CASE expression COLON
  private static boolean switchLabel_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchLabel_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE);
    r = r && expression(b, l + 1);
    r = r && consumeToken(b, COLON);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COLON IDENTIFIER
  public static boolean symbol(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "symbol")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokens(b, 1, COLON, IDENTIFIER);
    p = r; // pin = 1
    exit_section_(b, l, m, SYMBOL, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // TRY block (catches FINALLY block | catches | FINALLY block)
  public static boolean tryStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement")) return false;
    if (!nextTokenIs(b, TRY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRY);
    r = r && block(b, l + 1);
    r = r && tryStatement_2(b, l + 1);
    exit_section_(b, m, TRY_STATEMENT, r);
    return r;
  }

  // catches FINALLY block | catches | FINALLY block
  private static boolean tryStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tryStatement_2_0(b, l + 1);
    if (!r) r = catches(b, l + 1);
    if (!r) r = tryStatement_2_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // catches FINALLY block
  private static boolean tryStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = catches(b, l + 1);
    r = r && consumeToken(b, FINALLY);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // FINALLY block
  private static boolean tryStatement_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tryStatement_2_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FINALLY);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // qualifiedName ('[' ']')*
  public static boolean type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = qualifiedName(b, l + 1);
    r = r && type_1(b, l + 1);
    exit_section_(b, m, TYPE, r);
    return r;
  }

  // ('[' ']')*
  private static boolean type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!type_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // '[' ']'
  private static boolean type_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '+' unaryExpression
  //                   | '-' unaryExpression
  //                   | '++' unaryExpression
  //                   | '--' unaryExpression
  //                   | unaryExpressionNotPlusMinus
  static boolean unaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unaryExpression_0(b, l + 1);
    if (!r) r = unaryExpression_1(b, l + 1);
    if (!r) r = unaryExpression_2(b, l + 1);
    if (!r) r = unaryExpression_3(b, l + 1);
    if (!r) r = unaryExpressionNotPlusMinus(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '+' unaryExpression
  private static boolean unaryExpression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpression_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUS);
    r = r && unaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '-' unaryExpression
  private static boolean unaryExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpression_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUB);
    r = r && unaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '++' unaryExpression
  private static boolean unaryExpression_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpression_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUSPLUS);
    r = r && unaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '--' unaryExpression
  private static boolean unaryExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpression_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUBSUB);
    r = r && unaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '~' unaryExpression
  //                               | BANG unaryExpression
  //                               | primary selector* ('++' | '--')?
  static boolean unaryExpressionNotPlusMinus(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpressionNotPlusMinus")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unaryExpressionNotPlusMinus_0(b, l + 1);
    if (!r) r = unaryExpressionNotPlusMinus_1(b, l + 1);
    if (!r) r = unaryExpressionNotPlusMinus_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '~' unaryExpression
  private static boolean unaryExpressionNotPlusMinus_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpressionNotPlusMinus_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TILDE);
    r = r && unaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // BANG unaryExpression
  private static boolean unaryExpressionNotPlusMinus_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpressionNotPlusMinus_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BANG);
    r = r && unaryExpression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // primary selector* ('++' | '--')?
  private static boolean unaryExpressionNotPlusMinus_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpressionNotPlusMinus_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primary(b, l + 1);
    r = r && unaryExpressionNotPlusMinus_2_1(b, l + 1);
    r = r && unaryExpressionNotPlusMinus_2_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // selector*
  private static boolean unaryExpressionNotPlusMinus_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpressionNotPlusMinus_2_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!selector(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "unaryExpressionNotPlusMinus_2_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ('++' | '--')?
  private static boolean unaryExpressionNotPlusMinus_2_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpressionNotPlusMinus_2_2")) return false;
    unaryExpressionNotPlusMinus_2_2_0(b, l + 1);
    return true;
  }

  // '++' | '--'
  private static boolean unaryExpressionNotPlusMinus_2_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpressionNotPlusMinus_2_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PLUSPLUS);
    if (!r) r = consumeToken(b, SUBSUB);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'using' qualifiedName ('as' componentName)? ';'
  public static boolean usingDeclaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usingDeclaration")) return false;
    if (!nextTokenIs(b, USING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeToken(b, USING);
    p = r; // pin = 1
    r = r && report_error_(b, qualifiedName(b, l + 1));
    r = p && report_error_(b, usingDeclaration_2(b, l + 1)) && r;
    r = p && consumeToken(b, SEMI) && r;
    exit_section_(b, l, m, USING_DECLARATION, r, p, null);
    return r || p;
  }

  // ('as' componentName)?
  private static boolean usingDeclaration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usingDeclaration_2")) return false;
    usingDeclaration_2_0(b, l + 1);
    return true;
  }

  // 'as' componentName
  private static boolean usingDeclaration_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "usingDeclaration_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AS);
    r = r && componentName(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // componentName
  public static boolean variableDeclarationName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclarationName")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = componentName(b, l + 1);
    exit_section_(b, m, VARIABLE_DECLARATION_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // variableDeclarationName ('[' ']')* (EQ variableInitializer)?
  public static boolean variableDeclarator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclarator")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variableDeclarationName(b, l + 1);
    r = r && variableDeclarator_1(b, l + 1);
    r = r && variableDeclarator_2(b, l + 1);
    exit_section_(b, m, VARIABLE_DECLARATOR, r);
    return r;
  }

  // ('[' ']')*
  private static boolean variableDeclarator_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclarator_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!variableDeclarator_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "variableDeclarator_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // '[' ']'
  private static boolean variableDeclarator_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclarator_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // (EQ variableInitializer)?
  private static boolean variableDeclarator_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclarator_2")) return false;
    variableDeclarator_2_0(b, l + 1);
    return true;
  }

  // EQ variableInitializer
  private static boolean variableDeclarator_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclarator_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ);
    r = r && variableInitializer(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // arrayInitializer | expression
  public static boolean variableInitializer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableInitializer")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<variable initializer>");
    r = arrayInitializer(b, l + 1);
    if (!r) r = expression(b, l + 1);
    exit_section_(b, l, m, VARIABLE_INITIALIZER, r, false, null);
    return r;
  }

}
