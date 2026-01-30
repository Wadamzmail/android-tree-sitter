/*
 *  This file is part of android-tree-sitter.
 *
 *  android-tree-sitter library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2.1 of the License, or (at your option) any later version.
 *
 *  android-tree-sitter library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *  along with android-tree-sitter.  If not, see <https://www.gnu.org/licenses/>.
 */

package dev.mutwakil.androidide.treesitter.util;

import dev.mutwakil.androidide.treesitter.TSInputEdit;
import dev.mutwakil.androidide.treesitter.TSLanguage;
import dev.mutwakil.androidide.treesitter.TSLookaheadIterator;
import dev.mutwakil.androidide.treesitter.TSNode;
import dev.mutwakil.androidide.treesitter.TSParser;
import dev.mutwakil.androidide.treesitter.TSPoint;
import dev.mutwakil.androidide.treesitter.TSQuery;
import dev.mutwakil.androidide.treesitter.TSQueryCapture;
import dev.mutwakil.androidide.treesitter.TSQueryCursor;
import dev.mutwakil.androidide.treesitter.TSQueryMatch;
import dev.mutwakil.androidide.treesitter.TSQueryPredicateStep;
import dev.mutwakil.androidide.treesitter.TSRange;
import dev.mutwakil.androidide.treesitter.TSTree;
import dev.mutwakil.androidide.treesitter.TSTreeCursor;
import dev.mutwakil.androidide.treesitter.TSTreeCursorNode;
import dev.mutwakil.androidide.treesitter.string.UTF16String;

/**
 * An object factory is responsible for creating and destroying tree sitter objects. A factory can be
 * used with custom object implementation for recycling and reusing those objects. The default
 * implementation of this interface always creates new instances.
 *
 * @author Akash Yadav
 */
public interface TSObjectFactory {

  TSInputEdit createInputEdit(
    int startByte,
    int oldEndByte,
    int newEndByte,
    TSPoint startPoint,
    TSPoint oldEndPoint,
    TSPoint newEndPoint
  );

  TSParser createParser(
    long parserPointer
  );

  TSQuery createQuery(
    long queryPointer
  );

  TSQueryCursor createQueryCursor(
    long pointer
  );

  TSPoint createPoint(
    int row,
    int column
  );

  TSRange createRange(
    int startByte,
    int endByte,
    TSPoint startPoint,
    TSPoint endPoint
  );

  TSRange[] createRangeArr(
    int size
  );

  TSNode createNode(
    int context0,
    int context1,
    int context2,
    int context3,
    long id,
    long treePointer
  );

  TSTree createTree(
    long pointer
  );

  TSTreeCursor createTreeCursor(
    long pointer
  );

  TSQueryCapture createQueryCapture(
    TSNode node,
    int index
  );

  TSQueryMatch createQueryMatch(
    int id,
    int patternIndex,
    TSQueryCapture[] captures
  );

  TSQueryPredicateStep createQueryPredicateStep(
    int type,
    int valueId
  );

  TSQueryPredicateStep[] createQueryPredicateStepArr(
    int size
  );

  TSTreeCursorNode createTreeCursorNode(
    String type,
    String name,
    int startByte,
    int endByte
  );

  TSLookaheadIterator createLookaheadIterator(
    long pointer
  );

  TSLanguage createLanguage(
    String name,
    long[] pointers
  );

  UTF16String createString(long pointer, boolean isSynchronized);
}
