package ru.gb.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.gb.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 position;
    private Vector2 newPosition;
    private float speed;
    private Vector2 direction;
    private Vector2 velocity;

    @Override
    public void show() {
        super.show();
        img = new Texture("badlogic.jpg");
        position = new Vector2();
        newPosition = new Vector2();
        speed = 1.0f;
        direction = new Vector2();
        velocity = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(img, position.x, position.y);
        batch.end();
        if ((int) position.x != newPosition.x && (int) position.y != newPosition.y) {
            position.add(velocity);
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        newPosition.set(screenX, Gdx.graphics.getHeight() - screenY);
        direction.set(newPosition).sub(position).nor();
        velocity = direction.cpy().scl(speed);
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        position.set(screenX, Gdx.graphics.getHeight() - screenY);
        return super.touchDragged(screenX, screenY, pointer);
    }
}
