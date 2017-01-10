package org.janusgraph.graphdb.types.system;

import org.janusgraph.core.EdgeLabel;
import org.janusgraph.core.Multiplicity;
import org.janusgraph.graphdb.internal.JanusGraphSchemaCategory;
import org.apache.tinkerpop.gremlin.structure.Direction;

public class BaseLabel extends BaseRelationType implements EdgeLabel {

    public static final BaseLabel SchemaDefinitionEdge =
            new BaseLabel("SchemaRelated", 36, Direction.BOTH, Multiplicity.MULTI);

    public static final BaseLabel VertexLabelEdge =
            new BaseLabel("vertexlabel", 2, Direction.OUT, Multiplicity.MANY2ONE);


    private final Direction directionality;
    private final Multiplicity multiplicity;

    private BaseLabel(String name, int id, Direction uniDirectionality, Multiplicity multiplicity) {
        super(name, id, JanusGraphSchemaCategory.EDGELABEL);
        this.directionality = uniDirectionality;
        this.multiplicity = multiplicity;
    }

    @Override
    public long[] getSignature() {
        return new long[]{BaseKey.SchemaDefinitionDesc.longId()};
    }

    @Override
    public Multiplicity multiplicity() {
        return multiplicity;
    }

    @Override
    public final boolean isPropertyKey() {
        return false;
    }

    @Override
    public final boolean isEdgeLabel() {
        return true;
    }

    @Override
    public boolean isDirected() {
        return true;
    }

    @Override
    public boolean isUnidirected() {
        return isUnidirected(Direction.OUT);
    }

    @Override
    public boolean isUnidirected(Direction dir) {
        return dir== directionality;
    }


}