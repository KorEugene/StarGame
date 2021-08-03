package ru.gb.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.gb.base.Sprite;
import ru.gb.math.Rect;

public class Logo extends Sprite {

    private static final float V_LEN = 0.5f;

    private Vector2 touch;
    private Vector2 pos;
    private Vector2 v;

    public Logo(Texture texture, Vector2 pos) {
        super(new TextureRegion(texture));
        touch = new Vector2();
//        pos = new Vector2();
        this.pos = pos;
        v = new Vector2();
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        if (touch.dst(pos) > V_LEN) {
            pos.add(v);
        } else {
            pos.set(touch);
        }
    }

        @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight() / 8);
        pos.set(worldBounds.pos);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        touch.set(touch.x, Gdx.graphics.getHeight() - touch.y);
        v.set(touch.cpy().sub(pos)).setLength(V_LEN);
        return false;
    }

    @Override
    public boolean touchDragged(Vector2 touch, int pointer, int button) {
        pos.set(touch.x, Gdx.graphics.getHeight() - touch.y);
        return false;
    }
}
