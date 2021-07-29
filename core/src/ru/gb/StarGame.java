package ru.gb;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture backgroundTexture;
	Sprite backgroundSprite;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		backgroundTexture = new Texture(Gdx.files.internal("stars.jpg"));
		backgroundSprite = new Sprite(backgroundTexture);
		backgroundSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		backgroundSprite.setPosition(0,0f);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		backgroundSprite.draw(batch);
		batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void dispose () {
		backgroundTexture.dispose();
		batch.dispose();
		img.dispose();
	}
}
