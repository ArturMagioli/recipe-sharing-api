--Users
INSERT INTO users (username, password, email) VALUES
    ('ArturMagioli', '$2a$12$zFMJtAfKlh5Py3j9zbYlAuAZdKwXP3Wazx92ro88Tt2bUGObFmSmW', 'arturdepaula00@gmail.com'),
    ('JoaoSilva', '$2a$10$7EqJtq98hPqEX7fNZaFWoO5dZ6K5g5qJ5J5J5J5J5J5J5J5J5J5J5', 'joao.silva@gmail.com'),
    ('MariaOliveira', '$2a$10$WvvTP4p5qZ7gF6x8J9k0LuX1Y2Z3aBcDeFgHiJkLmNoPqRsTuVwXy', 'maria.oliveira@gmail.com'),
    ('PedroSantos', '$2a$10$K8v3J2mN5pQ7rT9wX1yZaO6bC4dE8fG0hI2jL5kM7nP9qR1sT3uVw', 'pedro.santos@gmail.com'),
    ('AnaCosta', '$2a$10$L4mN8pQ2rT6vX0yZaB3cDeFgHiJkLmNoPqRsTuVwXyZ1aBcDeFgHi', 'ana.costa@gmail.com'),
    ('LucasFerreira', '$2a$10$P2qR6tV0xY4zAbCdEfGhIjKlMnOpQrStUvWxYz1234567890abcdef', 'lucas.ferreira@gmail.com');

--Recipes
INSERT INTO recipes (user_id, title, description, ingredients, instructions, servings) VALUES
    (1, 'Carrot Cake with Chocolate Frosting', 'Quick and easy carrot cake topped with a delicious chocolate frosting.',
    '1/2 cup vegetable oil, 3 medium grated carrots, 4 eggs, 2 cups sugar, 2 1/2 cups all-purpose flour, ' ||
    '1 tbsp baking powder, 1 tbsp butter, 3 tbsp cocoa powder, 1 cup sugar, 1 cup milk.',
    'In a blender, combine the carrots, eggs, and vegetable oil. Add the sugar and blend for 5 minutes. ' ||
    'In a bowl, mix the flour with the blended mixture. Add the baking powder and gently stir until combined. ' ||
    'Pour the batter into a greased baking pan and bake in a preheated oven at 180°C (350°F) for approximately 40 minutes. ' ||
    'For the frosting, combine the butter, cocoa powder, sugar, and milk in a saucepan. ' ||
    'Cook over medium heat until thickened, then pour over the cake.',
    12),

    (1,'Beef Lasagna', 'Traditional lasagna with ground beef sauce, cheese, and ham, perfect for a family lunch.',
     '500g ground beef, 1 package of lasagna sheets, 2 cups tomato sauce, 300g mozzarella cheese, 200g ham,' ||
    '1 chopped onion, 2 garlic cloves, 1 tbsp olive oil, salt and pepper to taste.',
'Heat the olive oil in a pan and sauté the onion and garlic. Add the ground beef and cook until browned.' ||
    'Pour in the tomato sauce, season with salt and pepper, and simmer for 10 minutes. ' ||
    'In a baking dish, create layers of sauce, lasagna sheets, ham, and cheese. ' ||
    'Repeat the layers and finish with cheese on top. Bake in a preheated oven at 180°C (350°F) for approximately 35 minutes.',
    6),

    (1, 'Chicken Pancakes', 'Soft pancakes filled with shredded chicken and topped with tomato sauce.',
    '2 cups milk, 2 eggs, 2 cups all-purpose flour, 1 tbsp vegetable oil, 500g chicken breast, 1 chopped tomato,' ||
    '1 chopped onion, 2 garlic cloves, 1 cup tomato sauce, salt and fresh parsley to taste.',
'Blend the milk, eggs, flour, oil, and a pinch of salt until smooth.' ||
    'Heat a lightly greased frying pan and pour in small portions of batter, cooking until golden on both sides.' ||
    'For the filling, cook and shred the chicken. Sauté the onion, garlic, and tomato, then add the chicken and season with salt and fresh parsley.' ||
    'Fill and roll the pancakes, then place them in a baking dish. Cover with tomato sauce and bake for 15 minutes.',
    4),

    (1, 'Shrimp Risotto', 'Creamy risotto prepared with fresh shrimp, Parmesan cheese, and a touch of lemon.',
    '300g peeled shrimp, 2 cups Arborio rice, 1 l vegetable stock, 1/2 chopped onion, 2 garlic cloves, 1/2 cup dry white wine,' ||
    '2 tbsp butter, 100g grated Parmesan cheese, juice of 1/2 lemon, salt and pepper to taste.',
    'Season the shrimp with salt, pepper, and lemon juice. Melt one tbsp of butter in a pan and quickly sauté the shrimp until cooked.' ||
    'Set aside. In the same pan, sauté the onion and garlic. Add the Arborio rice and stir. Pour in the white wine and stir until it evaporates. ' ||
    'Gradually add the vegetable stock, stirring constantly until the rice is creamy and al dente. Add the shrimp, remaining butter, and Parmesan cheese. ' ||
    'Mix well and serve immediately.',4),

    (1,'Chocolate Brownies', 'Chocolate brownies with a crispy crust and a soft, fudgy center.',
    '200g dark chocolate, 150g butter, 1 cup sugar, 3 eggs, 1 cup all-purpose flour, 1/2 cup cocoa powder, 1 tsp vanilla extract, and a pinch of salt.',
    'Melt the dark chocolate and butter together using a double boiler or microwave. In a bowl, mix the eggs and sugar. ' ||
    'Add the melted chocolate and vanilla extract. Gradually add the flour, cocoa powder, and salt, stirring gently until combined. ' ||
    'Pour the batter into a greased baking pan lined with parchment paper. Bake in a preheated oven at 180°C (350°F) for approximately 25 to 30 minutes. ' ||
    'Allow to cool before cutting.',9),

    (2, 'Baked Mac and Cheese', 'Creamy macaroni and cheese baked in the oven with a crispy golden topping.',
    '300g elbow macaroni, 2 cups milk, 2 tbsp butter, 2 tbsp all-purpose flour, 200g shredded cheddar cheese,' ||
    '100g mozzarella cheese, 1/2 cup breadcrumbs, salt and black pepper to taste.',
    'Cook the macaroni in salted boiling water until al dente. In a saucepan, melt the butter, add the flour, and stir for one minute. ' ||
    'Gradually pour in the milk, stirring until the sauce thickens. Add the cheddar and mozzarella cheese and mix until melted. ' ||
    'Combine the sauce with the macaroni and transfer to a baking dish. ' ||
    'Sprinkle breadcrumbs on top and bake in a preheated oven at 180°C (350°F) for approximately 25 minutes, until golden.', 4),

    (2, 'Frozen Berry Smoothie', 'A refreshing and creamy smoothie made with frozen berries, banana, and yogurt.',
    '1 cup frozen strawberries, 1/2 cup frozen blueberries, 1 frozen banana, 1 cup natural yogurt, 1/2 cup milk, 1 tbsp honey.',
    'Add the frozen strawberries, blueberries, banana, yogurt, milk, and honey to a blender. Blend until smooth and creamy. ' ||
    'If the mixture is too thick, add a little more milk. Serve immediately while cold.', 2),

    (3, 'Baked Chicken Parmesan', 'Breaded chicken breasts baked with tomato sauce and melted mozzarella cheese.',
    '2 chicken breasts, 1 cup breadcrumbs, 1/2 cup all-purpose flour, 2 eggs, 1 cup tomato sauce, 200g mozzarella cheese, ' ||
    '50g grated Parmesan cheese, 1 tsp garlic powder, salt and black pepper to taste.',
    'Season the chicken breasts with salt, pepper, and garlic powder. Coat each piece in flour, dip it into beaten eggs, and cover with breadcrumbs. ' ||
    'Place the chicken on a greased baking tray and bake at 200°C (400°F) for 20 minutes. ' ||
    'Remove from the oven, cover each piece with tomato sauce and mozzarella cheese, and sprinkle Parmesan on top. ' ||
    'Return to the oven for another 10 minutes, until the cheese melts and the chicken is fully cooked.', 2),

    (3, 'Frozen Vegetable Stir-Fry', 'A quick and nutritious vegetable stir-fry prepared with frozen mixed vegetables and soy sauce.',
    '400g frozen mixed vegetables, 2 tbsp soy sauce, 1 tbsp sesame oil, 2 garlic cloves, 1 tsp grated ginger, ' ||
    '1 tbsp olive oil, 1 tbsp sesame seeds.', 'Heat the olive oil in a large frying pan or wok. ' ||
    'Add the garlic and ginger and sauté for one minute. Add the frozen vegetables directly to the pan and cook over medium-high heat until' ||
    'tender and heated through. Pour in the soy sauce and sesame oil. Stir well and cook for another two minutes. ' ||
    'Sprinkle sesame seeds on top before serving.', 3),

    (4, 'Blueberry Muffins', 'Soft and fluffy homemade muffins filled with juicy blueberries and a lightly sweetened batter.',
    '2 cups all-purpose flour, 3/4 cup sugar, 2 tsp baking powder, 2 eggs, 1/2 cup milk, 1/2 cup melted butter, ' ||
    '1 tsp vanilla extract, 1 cup fresh or frozen blueberries, 1 pinch of salt.', 'Preheat the oven to 180°C (350°F) and prepare ' ||
    'a muffin tin with paper liners. In a bowl, combine the flour, sugar, baking powder, and salt. In another bowl, ' ||
    'whisk together the eggs, milk, melted butter, and vanilla extract. Pour the wet ingredients into the dry ingredients and mix gently. ' ||
    'Fold in the blueberries. Divide the batter among the muffin cups and bake for 20 to 25 minutes, until golden and a toothpick inserted' ||
    'into the center comes out clean.', 10),

    (4, 'Frozen Shrimp Pasta', 'A delicious pasta dish prepared with frozen shrimp, garlic, olive oil, and fresh herbs.',
    '250g pasta, 300g frozen peeled shrimp, 3 garlic cloves, 3 tbsp olive oil, 1/2 tsp chili flakes, 1/2 lemon,' ||
    '2 tbsp chopped parsley, salt and black pepper to taste.', 'Cook the pasta in salted boiling water according to the ' ||
    'package instructions. Thaw the shrimp according to the package instructions and drain thoroughly. Heat the olive oil in a ' ||
    'skillet and sauté the garlic until fragrant. Add the shrimp and chili flakes and cook until the shrimp turn pink and opaque. ' ||
    'Add the cooked pasta, lemon juice, parsley, salt, and pepper. Toss everything together and serve warm.', 3),

    (5, 'Baked Apple Crumble', 'A warm dessert made with tender baked apples covered with a buttery and crunchy crumble topping.',
    '4 apples, 1/2 cup brown sugar, 1 tsp ground cinnamon, 1 tbsp lemon juice, 1 cup all-purpose flour, 1/2 cup rolled oats, ' ||
    '100g cold butter, 1/4 cup white sugar.', 'Preheat the oven to 180°C (350°F). Peel and slice the apples, then mix them with brown sugar, ' ||
    'cinnamon, and lemon juice. Transfer the apples to a baking dish. In a separate bowl, combine the flour, oats, and white sugar. ' ||
    'Add the cold butter and rub it into the dry ingredients until crumbly. Spread the crumble mixture over the apples. ' ||
    'Bake for 35 to 40 minutes, until the topping is golden and the apples are tender.', 6),

    (5, 'Frozen Corn Soup', 'A creamy and comforting soup made with frozen sweet corn, potatoes, and vegetable broth.',
    '400g frozen sweet corn, 2 medium potatoes, 1 chopped onion, 2 garlic cloves, 750ML vegetable broth, 1/2 cup heavy cream, ' ||
    '1 tbsp butter, salt and black pepper to taste.', 'Melt the butter in a large saucepan and sauté the onion and ' ||
    'garlic until soft. Add the frozen corn, diced potatoes, and vegetable broth. Bring to a boil and simmer for approximately 20 minutes, ' ||
    'until the potatoes are tender. Blend the mixture until creamy using an immersion blender. Stir in the heavy cream and season with salt ' ||
    'and pepper. Heat gently for a few more minutes and serve warm.', 4),

    (5, 'Baked Salmon with Herbs', 'Oven-baked salmon fillets seasoned with lemon, garlic, and fresh herbs for a healthy and flavorful meal.',
    '4 salmon fillets, 2 tbsp olive oil, 3 garlic cloves, 1 lemon, 1 tsp dried oregano, 1 tsp dried thyme, ' ||
    'salt and black pepper to taste.', 'Preheat the oven to 200°C (400°F). Place the salmon fillets in a baking dish. In a small bowl, ' ||
    'mix the olive oil, minced garlic, lemon juice, oregano, thyme, salt, and pepper. Pour the seasoning over the salmon. ' ||
    'Arrange lemon slices on top of the fillets. Bake for approximately 15 to 20 minutes, or until the salmon is cooked through and flakes easily with a fork.', 4),

    (6, 'Frozen Banana Ice Cream', 'A simple homemade frozen dessert made with ripe frozen bananas and peanut butter, with no added sugar.',
    '4 ripe frozen bananas, 2 tbsp peanut butter, 1 tsp vanilla extract, 2 tbsp milk (optional), 2 tbsp chopped dark chocolate.',
    'Peel and slice the bananas before freezing them for at least 4 hours. Place the frozen banana slices in a food processor and blend until creamy, ' ||
    'scraping down the sides as needed. Add the peanut butter and vanilla extract and blend again until smooth. ' ||
    'Add a little milk if necessary to help the mixture blend. Fold in the chopped dark chocolate. Serve immediately for a soft-serve ' ||
    'texture or freeze for another 1 to 2 hours for a firmer consistency.', 4);

--Ingredients
INSERT INTO ingredients (recipe_id, ingredient_value, unit, ingredient_type) VALUES
-- Recipe 1: Carrot Cake with Chocolate Frosting
    (1, 120, 'ML', 'vegetable oil'),
    (1, 3, 'PC', 'carrots'),
    (1, 4, 'PC', 'eggs'),
    (1, 400, 'G', 'sugar'),
    (1, 300, 'G', 'all-purpose flour'),
    (1, 15, 'G', 'baking powder'),
    (1, 14, 'G', 'butter'),
    (1, 15, 'G', 'cocoa powder'),
    (1, 200, 'G', 'sugar'),
    (1, 240, 'ML', 'milk'),

-- Recipe 2: Beef Lasagna
    (2, 500, 'G', 'ground beef'),
    (2, 1, 'PC', 'lasagna sheets package'),
    (2, 480, 'ML', 'tomato sauce'),
    (2, 300, 'G', 'mozzarella cheese'),
    (2, 200, 'G', 'ham'),
    (2, 1, 'PC', 'onion'),
    (2, 2, 'PC', 'garlic cloves'),
    (2, 15, 'ML', 'olive oil'),
    (2, 1, 'PINCH', 'salt'),
    (2, 1, 'PINCH', 'black pepper'),

-- Recipe 3: Chicken Pancakes
    (3, 480, 'ML', 'milk'),
    (3, 2, 'PC', 'eggs'),
    (3, 240, 'G', 'all-purpose flour'),
    (3, 15, 'ML', 'vegetable oil'),
    (3, 500, 'G', 'chicken breast'),
    (3, 1, 'PC', 'tomato'),
    (3, 1, 'PC', 'onion'),
    (3, 2, 'PC', 'garlic cloves'),
    (3, 240, 'ML', 'tomato sauce'),
    (3, 1, 'PINCH', 'salt'),
    (3, 1, 'PINCH', 'fresh parsley'),

-- Recipe 4: Shrimp Risotto
    (4, 300, 'G', 'peeled shrimp'),
    (4, 360, 'G', 'Arborio rice'),
    (4, 1, 'L', 'vegetable stock'),
    (4, 0.5, 'PC', 'onion'),
    (4, 2, 'PC', 'garlic cloves'),
    (4, 120, 'ML', 'dry white wine'),
    (4, 28, 'G', 'butter'),
    (4, 100, 'G', 'Parmesan cheese'),
    (4, 0.5, 'PC', 'lemon'),
    (4, 1, 'PINCH', 'salt'),
    (4, 1, 'PINCH', 'black pepper'),

-- Recipe 5: Chocolate Brownies
    (5, 200, 'G', 'dark chocolate'),
    (5, 150, 'G', 'butter'),
    (5, 200, 'G', 'sugar'),
    (5, 3, 'PC', 'eggs'),
    (5, 120, 'G', 'all-purpose flour'),
    (5, 40, 'G', 'cocoa powder'),
    (5, 1, 'TSP', 'vanilla extract'),
    (5, 1, 'PINCH', 'salt'),

-- Recipe 6: Baked Mac and Cheese
    (6, 300, 'G', 'elbow macaroni'),
    (6, 480, 'ML', 'milk'),
    (6, 28, 'G', 'butter'),
    (6, 16, 'G', 'all-purpose flour'),
    (6, 200, 'G', 'cheddar cheese'),
    (6, 100, 'G', 'mozzarella cheese'),
    (6, 60, 'G', 'breadcrumbs'),
    (6, 1, 'PINCH', 'salt'),
    (6, 1, 'PINCH', 'black pepper'),

-- Recipe 7: Frozen Berry Smoothie
    (7, 150, 'G', 'frozen strawberries'),
    (7, 75, 'G', 'frozen blueberries'),
    (7, 1, 'PC', 'frozen banana'),
    (7, 240, 'G', 'natural yogurt'),
    (7, 120, 'ML', 'milk'),
    (7, 15, 'ML', 'honey'),

-- Recipe 8: Baked Chicken Parmesan
    (8, 2, 'PC', 'chicken breasts'),
    (8, 120, 'G', 'breadcrumbs'),
    (8, 60, 'G', 'all-purpose flour'),
    (8, 2, 'PC', 'eggs'),
    (8, 240, 'ML', 'tomato sauce'),
    (8, 200, 'G', 'mozzarella cheese'),
    (8, 50, 'G', 'Parmesan cheese'),
    (8, 1, 'TSP', 'garlic powder'),
    (8, 1, 'PINCH', 'salt'),
    (8, 1, 'PINCH', 'black pepper'),

-- Recipe 9: Frozen Vegetable Stir-Fry
    (9, 400, 'G', 'frozen mixed vegetables'),
    (9, 30, 'ML', 'soy sauce'),
    (9, 15, 'ML', 'sesame oil'),
    (9, 2, 'PC', 'garlic cloves'),
    (9, 1, 'TSP', 'grated ginger'),
    (9, 15, 'ML', 'olive oil'),
    (9, 9, 'G', 'sesame seeds'),

-- Recipe 10: Blueberry Muffins
    (10, 240, 'G', 'all-purpose flour'),
    (10, 150, 'G', 'sugar'),
    (10, 10, 'G', 'baking powder'),
    (10, 2, 'PC', 'eggs'),
    (10, 120, 'ML', 'milk'),
    (10, 113, 'G', 'butter'),
    (10, 1, 'TSP', 'vanilla extract'),
    (10, 150, 'G', 'blueberries'),
    (10, 1, 'PINCH', 'salt'),

-- Recipe 11: Frozen Shrimp Pasta
    (11, 250, 'G', 'pasta'),
    (11, 300, 'G', 'frozen peeled shrimp'),
    (11, 3, 'PC', 'garlic cloves'),
    (11, 45, 'ML', 'olive oil'),
    (11, 0.5, 'TSP', 'chili flakes'),
    (11, 0.5, 'PC', 'lemon'),
    (11, 8, 'G', 'chopped parsley'),
    (11, 1, 'PINCH', 'salt'),
    (11, 1, 'PINCH', 'black pepper'),

-- Recipe 12: Baked Apple Crumble
    (12, 4, 'PC', 'apples'),
    (12, 100, 'G', 'brown sugar'),
    (12, 1, 'TSP', 'ground cinnamon'),
    (12, 15, 'ML', 'lemon juice'),
    (12, 120, 'G', 'all-purpose flour'),
    (12, 40, 'G', 'rolled oats'),
    (12, 100, 'G', 'butter'),
    (12, 50, 'G', 'white sugar'),

-- Recipe 13: Frozen Corn Soup
    (13, 400, 'G', 'frozen sweet corn'),
    (13, 2, 'PC', 'potatoes'),
    (13, 1, 'PC', 'onion'),
    (13, 2, 'PC', 'garlic cloves'),
    (13, 750, 'ML', 'vegetable broth'),
    (13, 120, 'ML', 'heavy cream'),
    (13, 14, 'G', 'butter'),
    (13, 1, 'PINCH', 'salt'),
    (13, 1, 'PINCH', 'black pepper'),

-- Recipe 14: Baked Salmon with Herbs
    (14, 4, 'PC', 'salmon fillets'),
    (14, 30, 'ML', 'olive oil'),
    (14, 3, 'PC', 'garlic cloves'),
    (14, 1, 'PC', 'lemon'),
    (14, 1, 'TSP', 'dried oregano'),
    (14, 1, 'TSP', 'dried thyme'),
    (14, 1, 'PINCH', 'salt'),
    (14, 1, 'PINCH', 'black pepper'),

-- Recipe 15: Frozen Banana Ice Cream
    (15, 4, 'PC', 'ripe frozen bananas'),
    (15, 32, 'G', 'peanut butter'),
    (15, 1, 'TSP', 'vanilla extract'),
    (15, 30, 'ML', 'milk'),
    (15, 20, 'G', 'chopped dark chocolate');
